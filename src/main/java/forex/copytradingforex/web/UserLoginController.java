package forex.copytradingforex.web;


import forex.copytradingforex.service.UserService;
import forex.copytradingforex.service.impl.CopyTradingForexUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
public class UserLoginController {
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "login";
    }

    @PostMapping("/users/login-error")
    public String failedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                    String username,
            RedirectAttributes redirectAttributes
    ){
        redirectAttributes.addFlashAttribute("bad_credentials", true);
        redirectAttributes.addFlashAttribute("username", username);

        return "redirect:/users/login";
    }

    @GetMapping("/users/profile")
    public String profile(Model model,
                          @AuthenticationPrincipal CopyTradingForexUser currentUser ){

        model.addAttribute("userProfile",
              userService.findByUsername(currentUser.getUserIdentifier()));

        return "profile";
    }


    @PostMapping("/users/deposit")
    public String depositAmount(@RequestParam("amount") BigDecimal amount,
                                @AuthenticationPrincipal CopyTradingForexUser currentUser
                                ){
        userService.depositAmount(amount,currentUser.getUserIdentifier() );

        return "redirect:/users/profile";
    }


    @PostMapping("/users/withdraw")
    public String withdrawAmount(@RequestParam("amount") BigDecimal amount,
                                @AuthenticationPrincipal CopyTradingForexUser currentUser
    ){

        userService.withdrawAmount(amount,currentUser.getUserIdentifier() );

        return "redirect:/users/profile";
    }

}
