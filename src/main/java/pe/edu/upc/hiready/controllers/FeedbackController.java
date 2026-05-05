package pe.edu.upc.hiready.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hiready.dtos.FeedbackDTO;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.repositories.UserRepository;
import pe.edu.upc.hiready.servicesInterfaces.IFeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final IFeedbackService feedbackService;
    private final UserRepository userRepository;

    public FeedbackController(IFeedbackService feedbackService, UserRepository userRepository) {
        this.feedbackService = feedbackService;
        this.userRepository = userRepository;
    }

    @GetMapping("/result/{resultId}")
    public ResponseEntity<FeedbackDTO> getByResult(@PathVariable Integer resultId) {
        return ResponseEntity.ok(feedbackService.getFeedbackByResult(resultId));
    }

    @GetMapping("/history")
    public ResponseEntity<List<FeedbackDTO>> getHistory(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(feedbackService.getUserFeedbackHistory(user.getUserId()));
    }
}
