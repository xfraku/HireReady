package pe.edu.upc.hiready.servicesInterfaces;

import pe.edu.upc.hiready.dtos.*;

import java.util.List;

public interface ISimulationService {
    SimulationDTO startSimulation(Integer userId, SimulationStartRequest request);
    SimulationDTO answerQuestion(Integer simulationId, AnswerRequest request);
    String getHint(Integer simulationId, Integer questionId);
    SimResultDTO completeSimulation(Integer simulationId);
    SimulationDTO resumeSimulation(Integer simulationId);
    List<SimulationDTO> getUserSimulations(Integer userId);
    SimResultDTO getSimulationResult(Integer simulationId);
}
