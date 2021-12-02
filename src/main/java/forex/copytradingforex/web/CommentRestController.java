package forex.copytradingforex.web;

import forex.copytradingforex.model.view.CommentViewModel;
import forex.copytradingforex.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/api/{positionId}/comments")
    public ResponseEntity<List<CommentViewModel>> getComments(
        @PathVariable Long positionId,
        Principal principal
        ){
        List<CommentViewModel> allComments = commentService.getAllComments(positionId);
        return ResponseEntity.ok(allComments);
    }
}
