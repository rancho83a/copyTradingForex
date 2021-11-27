package forex.copytradingforex.web;

import forex.copytradingforex.service.PositionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/positions")
public class PositionsController {
    private final PositionService positionService;

    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/all")
    public String allPositions(Model model) {

        model.addAttribute("positions", this.positionService.getAllPositions());
        return "positions";
    }

    //DETAILS
//    @GetMapping("/positions/{id}/details")
//    public String showOffer(@PathVariable Long id, Model model,
//                            @AuthenticationPrincipal MobileleUser currentUser) {
//        model.addAttribute("offer", this.offerService.findById(id, currentUser.getUserIdentifier()));
//        return "details";
//    }

}
