package forex.copytradingforex.web;

import forex.copytradingforex.model.binding.PictureAddBindingModel;
import forex.copytradingforex.model.entity.PictureEntity;
import forex.copytradingforex.model.service.CloudinaryImage;
import forex.copytradingforex.model.service.PictureAddServiceModel;
import forex.copytradingforex.service.CloudinaryService;
import forex.copytradingforex.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;

    public PictureController(CloudinaryService cloudinaryService, PictureService pictureService) {
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
    }

//    @GetMapping("/pictures/add")
//    public String addPicture(){
//        return "addPicture";
//    }

    @PostMapping("/{id}/pictures/add")
        public String addPicture(PictureAddBindingModel pictureAddBindingModel,
                                 @PathVariable Long id,
                                 Principal principal
    ) throws IOException {

//todo если просто нажать кнопку - ошибка
        PictureAddServiceModel pictureAddServiceModel = createPictureEntity(pictureAddBindingModel.getPicture(), pictureAddBindingModel.getTitle());
        pictureAddServiceModel.setPositionId(id);
        pictureAddServiceModel.setTraderUsername(principal.getName());

        pictureService.savePicture(pictureAddServiceModel);


        return "redirect:/positions/"+id+"/details";
    }


    private PictureAddServiceModel createPictureEntity(MultipartFile file, String title) throws IOException {
        CloudinaryImage uploaded = this.cloudinaryService.upload(file);

        return new PictureAddServiceModel()
                .setPublicId(uploaded.getPublicId())
                .setUrl(uploaded.getUrl())
                .setTitle(title);
    }
}
