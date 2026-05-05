package pe.edu.upc.hiready.controllers;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.hiready.dtos.ProfileDTO;
import pe.edu.upc.hiready.dtos.UserSkillDTO;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.repositories.UserRepository;
import pe.edu.upc.hiready.servicesInterfaces.IProfileService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final IProfileService profileService;
    private final UserRepository userRepository;

    public ProfileController(IProfileService profileService, UserRepository userRepository) {
        this.profileService = profileService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<ProfileDTO> getMyProfile(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(profileService.getProfile(user.getUserId()));
    }

    @PutMapping
    public ResponseEntity<ProfileDTO> updateProfile(@RequestBody ProfileDTO dto,
                                                    @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(profileService.createOrUpdateProfile(user.getUserId(), dto));
    }

    @PostMapping(value = "/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> uploadPicture(
            @RequestParam("file") MultipartFile file,
            @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        String url = profileService.uploadProfilePicture(user.getUserId(), file);
        return ResponseEntity.ok(Map.of("profilePictureUrl", url));
    }

    @GetMapping("/skills")
    public ResponseEntity<List<UserSkillDTO>> getSkills(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(profileService.getSkills(user.getUserId()));
    }

    @PostMapping("/skills")
    public ResponseEntity<UserSkillDTO> addSkill(@RequestBody UserSkillDTO dto,
                                                 @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(profileService.addSkill(user.getUserId(), dto));
    }

    @DeleteMapping("/skills/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Integer skillId,
                                            @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        profileService.deleteSkill(user.getUserId(), skillId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/language")
    public ResponseEntity<Map<String, String>> updateLanguage(@RequestBody Map<String, String> body,
                                                              @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        profileService.updateLanguage(user.getUserId(), body.get("language"));
        return ResponseEntity.ok(Map.of("message", "Idioma actualizado"));
    }
}
