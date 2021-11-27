package forex.copytradingforex.service.impl;

import forex.copytradingforex.model.entity.PositionEntity;
import forex.copytradingforex.model.view.PositionViewModel;
import forex.copytradingforex.repository.PositionRepository;
import forex.copytradingforex.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final ModelMapper modelMapper;

    public PositionServiceImpl(PositionRepository positionRepository, ModelMapper modelMapper) {
        this.positionRepository = positionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PositionViewModel> getAllPositions() {
        return this.positionRepository
                .findAll()
                .stream()
                .map(this::mapToPositionViewModel)
                .collect(Collectors.toList());
    }

    private PositionViewModel mapToPositionViewModel(PositionEntity position) {
        PositionViewModel positionViewModel = modelMapper.map(position, PositionViewModel.class);
        positionViewModel.setTrader(position.getTrader().getFullName()).setPictureUrl(position.getPicture().getUrl())
                .setEconomicIndicator(position.getEconomicIndicator().getIndicator().getIndicator())
                .setYield(calculateYield(position.getTrader().getCapital(),position.getFinancialResult()));

        return positionViewModel;
    }

    private BigDecimal calculateYield(BigDecimal capital, BigDecimal financialResult) {
        if(capital.compareTo(BigDecimal.ZERO) ==0) {
            return BigDecimal.ZERO;
        }

        BigDecimal yield =  financialResult.divide(capital).multiply(BigDecimal.valueOf(100));

        return yield.setScale(2, RoundingMode.FLOOR);


    }
}
