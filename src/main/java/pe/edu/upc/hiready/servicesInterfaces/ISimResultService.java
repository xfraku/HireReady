package pe.edu.upc.hiready.servicesInterfaces;

import java.util.List;

public interface ISimResultService {

    List<Object[]> getTopCandidates();

    List<Object[]> getLowTechnicalUsers();

    List<Object[]> avgScoreByMonth(int userId);
List<Object[]> findFeedbackByUser(int userId);
    
}
