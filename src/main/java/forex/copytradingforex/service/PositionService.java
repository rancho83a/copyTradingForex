package forex.copytradingforex.service;

import forex.copytradingforex.model.view.PositionDetailsView;
import forex.copytradingforex.model.view.PositionViewModel;

import java.util.List;

public interface PositionService {
    List<PositionViewModel> getAllPositions();

    PositionDetailsView findById(Long id, String userIdentifier);

    boolean isOwner(String username, Long id);

    void deleteOffer(Long id);
}
