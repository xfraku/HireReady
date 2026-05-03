package pe.edu.upc.hiready.servicesInterfaces;

import pe.edu.upc.hiready.dtos.FeedbackDTO;

import java.util.List;

public interface IFeedbackService {
    FeedbackDTO getFeedbackByResult(Integer resultId);
    List<FeedbackDTO> getUserFeedbackHistory(Integer userId);
}
