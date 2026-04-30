package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.ResponseType;
import pe.edu.upc.hireready1.repositories.IResponseTypeRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IResponseTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseTypeServiceImpl implements IResponseTypeService {

    @Autowired
    private IResponseTypeRepository responseTypeRepository;

    @Override
    public List<ResponseType> list() {
        return responseTypeRepository.findAll();
    }

    @Override
    public Optional<ResponseType> listById(Long id) {
        return responseTypeRepository.findById((Long) id);
    }

    @Override
    public ResponseType insert(ResponseType r) {
        return responseTypeRepository.save(r);
    }

    @Override
    public void update(ResponseType r) {
        responseTypeRepository.save(r);
    }

    @Override
    public void delete(Long id) {
        responseTypeRepository.deleteById((Long) id);
    }
}
