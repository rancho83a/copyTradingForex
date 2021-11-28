package forex.copytradingforex.web;

import forex.copytradingforex.service.PositionService;
import forex.copytradingforex.service.impl.CopyTradingForexUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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
    @GetMapping("/{id}/details")
    public String showPosition(@PathVariable Long id, Model model,
                               // Principal principal){
                               @AuthenticationPrincipal CopyTradingForexUser currentUser) {
                            //   @AuthenticationPrincipal UserDetails principal) {
        // model.addAttribute("oposition", this.positionService.findById(id, principal.getName()));
        model.addAttribute("position", this.positionService.findById(id, currentUser.getUserIdentifier()));
        return "position-details";
    }

    //DELETE
    @PreAuthorize("isOwner(#id)")
    //@PreAuthorize("@offerServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/{id}")
    public String deletePosition(@PathVariable Long id, Principal principal) {

        this.positionService.deleteOffer(id);
        return "redirect:/positions/all";
    }

}
