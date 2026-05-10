package pe.edu.upc.hiready.servicesInterfaces;

import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.hiready.dtos.ProfileDTO;
import pe.edu.upc.hiready.dtos.UserSkillDTO;

import java.util.List;

public interface IProfileService {
    ProfileDTO getProfile(Integer userId);
    ProfileDTO createOrUpdateProfile(Integer userId, ProfileDTO dto);
    String uploadProfilePicture(Integer userId, MultipartFile file);
    List<UserSkillDTO> getSkills(Integer userId);
    UserSkillDTO addSkill(Integer userId, UserSkillDTO dto);
    void deleteSkill(Integer userId, Integer skillId);
    void updateLanguage(Integer userId, String language);
}
