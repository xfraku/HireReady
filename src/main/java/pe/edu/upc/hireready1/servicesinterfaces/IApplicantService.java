package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Applicant;

import java.util.List;
import java.util.Optional;

public interface IApplicantService {
    public Applicant insert(Applicant a);
    public List<Applicant> list();
    public void update(Applicant a);
    public void delete(Long id);
    public Optional<Applicant> listById(Long id);
}
