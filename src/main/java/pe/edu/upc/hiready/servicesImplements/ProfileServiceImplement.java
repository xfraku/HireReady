package pe.edu.upc.hiready.servicesImplements;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.hiready.dtos.ProfileDTO;
import pe.edu.upc.hiready.dtos.UserSkillDTO;
import pe.edu.upc.hiready.entities.Profile;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.entities.UserSkill;
import pe.edu.upc.hiready.exceptions.ResourceNotFoundException;
import pe.edu.upc.hiready.repositories.ProfileRepository;
import pe.edu.upc.hiready.repositories.UserRepository;
import pe.edu.upc.hiready.repositories.UserSkillRepository;
import pe.edu.upc.hiready.servicesInterfaces.IProfileService;
import pe.edu.upc.hiready.servicesInterfaces.IS3Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImplement implements IProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final UserSkillRepository userSkillRepository;
    private final IS3Service s3Service;

    public ProfileServiceImplement(ProfileRepository profileRepository,
                                   UserRepository userRepository,
                                   UserSkillRepository userSkillRepository,
                                   IS3Service s3Service) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.userSkillRepository = userSkillRepository;
        this.s3Service = s3Service;
    }

    @Override
    public ProfileDTO getProfile(Integer userId) {
        Profile profile = profileRepository.findByUserUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil no encontrado"));
        return toDTO(profile);
    }

    @Override
    @Transactional
    public ProfileDTO createOrUpdateProfile(Integer userId, ProfileDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Profile profile = profileRepository.findByUserUserId(userId).orElseGet(Profile::new);
        profile.setUser(user);
        profile.setLinkedinUrl(dto.getLinkedinUrl());
        profile.setFacebookUrl(dto.getFacebookUrl());
        profile.setCareer(dto.getCareer());
        profile.setExperience(dto.getExperience());
        profile.setExperienceYears(dto.getExperienceYears());
        profile.setEduInstitution(dto.getEduInstitution());
        profile.setDegree(dto.getDegree());

        Profile saved = profileRepository.save(profile);
        return toDTO(saved);
    }

    @Override
    @Transactional
    public String uploadProfilePicture(Integer userId, MultipartFile file) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        if (user.getProfilePictureUrl() != null) {
            try { s3Service.deleteFile(user.getProfilePictureUrl()); } catch (Exception ignored) {}
        }

        String url = s3Service.uploadFile(file, "profile-pictures");
        user.setProfilePictureUrl(url);
        userRepository.save(user);
        return url;
    }

    @Override
    public List<UserSkillDTO> getSkills(Integer userId) {
        Profile profile = profileRepository.findByUserUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil no encontrado"));
        return userSkillRepository.findByProfileProfileId(profile.getProfileId())
                .stream().map(this::toSkillDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserSkillDTO addSkill(Integer userId, UserSkillDTO dto) {
        Profile profile = profileRepository.findByUserUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil no encontrado. Crea tu perfil primero."));

        UserSkill skill = new UserSkill();
        skill.setProfile(profile);
        skill.setSkillName(dto.getSkillName());
        skill.setSkillDescription(dto.getSkillDescription());
        skill.setSkillType(dto.getSkillType());

        return toSkillDTO(userSkillRepository.save(skill));
    }

    @Override
    @Transactional
    public void deleteSkill(Integer userId, Integer skillId) {
        UserSkill skill = userSkillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill no encontrada"));
        if (!skill.getProfile().getUser().getUserId().equals(userId)) {
            throw new SecurityException("No autorizado");
        }
        userSkillRepository.delete(skill);
    }

    @Override
    @Transactional
    public void updateLanguage(Integer userId, String language) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        user.setLanguagePref(language);
        userRepository.save(user);
    }

    private ProfileDTO toDTO(Profile p) {
        ProfileDTO dto = new ProfileDTO();
        dto.setProfileId(p.getProfileId());
        dto.setUserId(p.getUser().getUserId());
        dto.setLinkedinUrl(p.getLinkedinUrl());
        dto.setFacebookUrl(p.getFacebookUrl());
        dto.setCareer(p.getCareer());
        dto.setExperience(p.getExperience());
        dto.setExperienceYears(p.getExperienceYears());
        dto.setEduInstitution(p.getEduInstitution());
        dto.setDegree(p.getDegree());

        List<UserSkillDTO> skills = userSkillRepository.findByProfileProfileId(p.getProfileId())
                .stream().map(this::toSkillDTO).collect(Collectors.toList());
        dto.setSkills(skills);
        return dto;
    }

    private UserSkillDTO toSkillDTO(UserSkill s) {
        UserSkillDTO dto = new UserSkillDTO();
        dto.setUserSkillId(s.getUserSkillId());
        dto.setSkillName(s.getSkillName());
        dto.setSkillDescription(s.getSkillDescription());
        dto.setSkillType(s.getSkillType());
        return dto;
    }
}
