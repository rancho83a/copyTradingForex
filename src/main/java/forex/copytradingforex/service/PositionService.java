package forex.copytradingforex.service;

import forex.copytradingforex.model.view.PositionViewModel;

import java.util.List;

public interface PositionService {
    List<PositionViewModel> getAllPositions();
}
