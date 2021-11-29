package forex.copytradingforex.service.impl;

import forex.copytradingforex.model.view.EconomicIndicatorViewModel;
import forex.copytradingforex.repository.EconomicIndicatorRepository;
import forex.copytradingforex.service.EconomicIndicatorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EconomicIndicatorServiceImpl implements EconomicIndicatorService {
    private final EconomicIndicatorRepository economicIndicatorRepository;
    private final ModelMapper modelMapper;

    public EconomicIndicatorServiceImpl(EconomicIndicatorRepository economicIndicatorRepository, ModelMapper modelMapper) {
        this.economicIndicatorRepository = economicIndicatorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EconomicIndicatorViewModel> getAllEconomicIndicators() {

        List<EconomicIndicatorViewModel> indicators = this.economicIndicatorRepository.findAll()
                .stream()
                .map(indicator -> {
                    EconomicIndicatorViewModel economicIndicatorViewModel = modelMapper.map(indicator, EconomicIndicatorViewModel.class);

                    economicIndicatorViewModel.setIndicator(indicator.getIndicator().getName());
                    return economicIndicatorViewModel;
                })
                .collect(Collectors.toList());

        return indicators;
    }
}
