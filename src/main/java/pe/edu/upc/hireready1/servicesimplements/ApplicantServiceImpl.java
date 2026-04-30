package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Applicant;
import pe.edu.upc.hireready1.repositories.IApplicantRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IApplicantService;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements IApplicantService {

    @Autowired
    private IApplicantRepository applicantRepository;

    @Override
    public List<Applicant> list() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant insert(Applicant a) {
        return applicantRepository.save(a);
    }

    @Override
    public Optional<Applicant> listId(int id) {
        return applicantRepository.findById((long) id);
    }

    @Override
    public void update(Applicant a) {
        applicantRepository.save(a);
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById((long) id);
    }
}
