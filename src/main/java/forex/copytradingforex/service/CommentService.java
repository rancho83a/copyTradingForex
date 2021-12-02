package forex.copytradingforex.service;

import forex.copytradingforex.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {
    List<CommentViewModel> getAllComments(Long positionId);
}
