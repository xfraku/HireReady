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
    public ResponseType insert(ResponseType r) {
        return responseTypeRepository.save(r);
    }

    @Override
    public Optional<ResponseType> listId(int id) {
        return responseTypeRepository.findById((long) id);
    }

    @Override
    public void update(ResponseType r) {
        responseTypeRepository.save(r);
    }

    @Override
    public void delete(int id) {
        responseTypeRepository.deleteById((long) id);
    }
}
