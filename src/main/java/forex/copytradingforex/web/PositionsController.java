package forex.copytradingforex.web;

import forex.copytradingforex.model.binding.PositionAddBindingModel;
import forex.copytradingforex.model.entity.service.PositionAddServiceModel;
import forex.copytradingforex.service.EconomicIndicatorService;
import forex.copytradingforex.service.PositionService;
import forex.copytradingforex.service.impl.CopyTradingForexUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/positions")
public class PositionsController {
    private final PositionService positionService;
    private final EconomicIndicatorService economicIndicatorService;

    public PositionsController(PositionService positionService, EconomicIndicatorService economicIndicatorService) {
        this.positionService = positionService;
        this.economicIndicatorService = economicIndicatorService;
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
    //@PreAuthorize("@positionServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/{id}")
    public String deletePosition(@PathVariable Long id, Principal principal) {

        this.positionService.deletePosition(id);
        return "redirect:/positions/all";
    }

    @GetMapping("/add")
    public String getAddPositionPage(Model model) {

        if (!model.containsAttribute("positionAddBindModel")) {
            model
                    .addAttribute("positionAddBindModel", new PositionAddBindingModel())
                    .addAttribute("economicIndicators", economicIndicatorService.getAllEconomicIndicators());
        }
        return "position-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid PositionAddBindingModel positionAddBindModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal CopyTradingForexUser user) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("positionAddBindModel", positionAddBindModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.positionAddBindModel", bindingResult)
                    .addFlashAttribute("economicIndicators", economicIndicatorService.getAllEconomicIndicators());
            return "redirect:/positions/add";
        }
        PositionAddServiceModel savedPositionAddServiceModel = positionService.addPosition(positionAddBindModel, user.getUsername());
        return "redirect:/positions/" + savedPositionAddServiceModel.getId() + "/details";
    }





}
