package forex.copytradingforex.service.impl;

import forex.copytradingforex.model.entity.PositionEntity;
import forex.copytradingforex.model.entity.RoleEntity;
import forex.copytradingforex.model.entity.UserEntity;
import forex.copytradingforex.model.entity.enums.RoleEnum;
import forex.copytradingforex.model.view.PositionDetailsView;
import forex.copytradingforex.model.view.PositionViewModel;
import forex.copytradingforex.repository.PositionRepository;
import forex.copytradingforex.repository.UserRepository;
import forex.copytradingforex.service.PositionService;
import forex.copytradingforex.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public PositionServiceImpl(PositionRepository positionRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.positionRepository = positionRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    //TODO get ORDERBY DATEOPEN limit 40
    public List<PositionViewModel> getAllPositions() {
        return this.positionRepository
                .findAll()
                .stream()
                .map(this::mapToPositionViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDetailsView findById(Long id, String currentUser) {
        PositionEntity positionEntity = this.positionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Position with id: " + id + " was not found"));
        PositionDetailsView positionDetailsView = modelMapper.map(positionEntity, PositionDetailsView.class);
        positionDetailsView.setTrader(positionEntity.getTrader().getFullName()).setPictureUrl(positionEntity.getPicture().getUrl())
                .setEconomicIndicator(positionEntity.getEconomicIndicator().getIndicator().getName())
                .setYield(calculateYield(positionEntity.getTrader().getCapital(), positionEntity.getFinancialResult()))
                .setVideoUrl(positionEntity.getVideoUrl())
                .setOpenTime(positionEntity.getOpenTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .setCloseTime(positionEntity.getCloseTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .setCanDeleteOrUpdate(isOwner(currentUser, positionEntity.getId()));


        return positionDetailsView;
    }

    @Override
    public boolean isOwner(String username, Long id) {
        Optional<PositionEntity> positionOpt = positionRepository.findById(id);
        Optional<UserEntity> ownOpt = userRepository.findByUsername(username);

        if (positionOpt.isEmpty() || ownOpt.isEmpty()) {
            return false;
        }
        PositionEntity positionEntity = positionOpt.get();
        UserEntity owner = ownOpt.get();


        return isMaster(owner) || positionEntity.getTrader().getUsername().equals(username);
    }

    @Override
    public void deleteOffer(Long id) {
        this.positionRepository.deleteById(id);
    }

    private boolean isMaster(UserEntity user) {
        return user.getRoles()
                .stream()
                .map(RoleEntity::getRole)
                .anyMatch(r -> r == RoleEnum.MASTER);


    }

    private PositionViewModel mapToPositionViewModel(PositionEntity position) {
        PositionViewModel positionViewModel = modelMapper.map(position, PositionViewModel.class);
        positionViewModel.setTrader(position.getTrader().getFullName()).setPictureUrl(position.getPicture().getUrl())
                .setEconomicIndicator(position.getEconomicIndicator().getIndicator().getName())
                .setYield(calculateYield(position.getTrader().getCapital(), position.getFinancialResult()));

        return positionViewModel;
    }

    private BigDecimal calculateYield(BigDecimal capital, BigDecimal financialResult) {
        if (capital.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal yield = financialResult.divide(capital).multiply(BigDecimal.valueOf(100));

        return yield.setScale(2, RoundingMode.FLOOR);


    }
}
