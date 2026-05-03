package pe.edu.upc.hiready.servicesImplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.hiready.dtos.FeedbackDTO;
import pe.edu.upc.hiready.entities.Feedback;
import pe.edu.upc.hiready.exceptions.ResourceNotFoundException;
import pe.edu.upc.hiready.repositories.FeedbackRepository;
import pe.edu.upc.hiready.servicesInterfaces.IFeedbackService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImplement implements IFeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImplement(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public FeedbackDTO getFeedbackByResult(Integer resultId) {
        Feedback feedback = feedbackRepository.findBySimResultResultId(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback no encontrado"));
        return toDTO(feedback);
    }

    @Override
    public List<FeedbackDTO> getUserFeedbackHistory(Integer userId) {
        return feedbackRepository.findBySimResultSimulationUserUserId(userId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private FeedbackDTO toDTO(Feedback f) {
        FeedbackDTO dto = new FeedbackDTO();
        dto.setFeedbackId(f.getFeedbackId());
        dto.setResultId(f.getSimResult().getResultId());
        dto.setFrequentErrors(f.getFrequentErrors());
        dto.setRecommendation(f.getRecommendation());
        return dto;
    }
}
