package pe.edu.upc.hiready.servicesInterfaces;

import java.util.List;

public interface ISimResultService {

    List<Object[]> getTopCandidates();

    List<Object[]> getLowTechnicalUsers();
}