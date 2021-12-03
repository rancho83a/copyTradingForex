package forex.copytradingforex.service.impl;

import forex.copytradingforex.model.entity.PositionEntity;
import forex.copytradingforex.model.service.CommentServiceModel;
import forex.copytradingforex.model.view.CommentViewModel;
import forex.copytradingforex.repository.CommentRepository;
import forex.copytradingforex.repository.PositionRepository;
import forex.copytradingforex.service.CommentService;
import forex.copytradingforex.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PositionRepository positionRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, PositionRepository positionRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.positionRepository = positionRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public List<CommentViewModel> getAllComments(Long positionId) {
        PositionEntity positionEntity = positionRepository.

                //There are 2 options to fix N+1 problem with fetch.LAZY and @Transactional

                //With special FETCH Query
                //findByIdByFetch(positionId)

                //Alternative for previous above method
                        findByIdByEntityGraph(positionId)

                .orElseThrow(
                        () -> new ObjectNotFoundException("Position with id" + positionId + " was not found")
                );
        List<CommentViewModel> commentsViewModel = positionEntity.getComments()
                .stream().map(c -> {
                    CommentViewModel commentViewModel = modelMapper.map(c, CommentViewModel.class);

                    commentViewModel.setOwner(c.getAuthor().getFullName());
                    return commentViewModel;
                })
                .collect(Collectors.toList());


        return commentsViewModel;
    }

    @Override
    public CommentViewModel createNewComment(CommentServiceModel commentServiceModel) {

        //TODO

        return null;
    }
}
