package pe.edu.upc.hiready.servicesImplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.hiready.repositories.SimResultRepository;
import pe.edu.upc.hiready.servicesInterfaces.ISimResultService;

import java.util.List;

@Service
public class SimResultServiceImplement implements ISimResultService {

    private final SimResultRepository simResultRepository;

    public SimResultServiceImplement(SimResultRepository simResultRepository) {
        this.simResultRepository = simResultRepository;
    }

    @Override
    public List<Object[]> getTopCandidates() {
        return simResultRepository.getTopCandidates();
    }

    @Override
    public List<Object[]> getLowTechnicalUsers() {
        return simResultRepository.getLowTechnicalUsers();
    }

    @Override
public List<Object[]> avgScoreByMonth(int userId) {
    return simResultRepository.avgScoreByMonth(userId);
}

@Override
public List<Object[]> findFeedbackByUser(int userId) {
    return simResultRepository.findFeedbackByUser(userId);
}
}
