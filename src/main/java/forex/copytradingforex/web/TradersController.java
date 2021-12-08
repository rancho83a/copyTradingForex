package forex.copytradingforex.web;


import forex.copytradingforex.service.UserService;
import forex.copytradingforex.service.impl.CopyTradingForexUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/traders")
public class TradersController {

    private final UserService userService;

    public TradersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public String allTraders(Model model,
                             @AuthenticationPrincipal CopyTradingForexUser currentInvestor) {

        if(!model.containsAttribute("canNotJoin")) {
            model.addAttribute("canNotJoin", false);
        }

        if(userService.isJoinedToCopy(currentInvestor.getUserIdentifier())){
            model.addAttribute("isJoinedToCopy", true);
        }
        model.addAttribute("traders", this.userService.getAllTraders());
        return "traders";
    }

    @GetMapping("/{id}/copy")
    public String joinToCopy(
            Model model,
            @PathVariable Long id,
            @AuthenticationPrincipal CopyTradingForexUser currentInvestor) {

        if(!userService.canJoin(currentInvestor.getUserIdentifier())){

            return "warning-no-join";
        }

        userService.joinToCopy(currentInvestor.getUserIdentifier(), id);

        return "redirect:/users/profile";
    }

    @GetMapping("/{traderId}/revoke")
    public String revokeTrader(
            Model model,
            @PathVariable Long traderId,
            @AuthenticationPrincipal CopyTradingForexUser currentInvestor) {

        userService.revokeTrader(currentInvestor.getUserIdentifier(), traderId);

        return "redirect:/users/profile";
    }

}

