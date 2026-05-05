package pe.edu.upc.hiready.servicesImplements;

import pe.edu.upc.hiready.entities.ModelAnswer;
import pe.edu.upc.hiready.dtos.ModelAnswerDTO;
import pe.edu.upc.hiready.repositories.ModelAnswerRepository;
import pe.edu.upc.hiready.servicesInterfaces.IModelAnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelAnswerImplement implements IModelAnswerService {

    private final ModelAnswerRepository repository;

    public ModelAnswerImplement(ModelAnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ModelAnswerDTO save(ModelAnswerDTO dto) {
        ModelAnswer entity = new ModelAnswer();
        entity.setContent(dto.getContent());

        ModelAnswer saved = repository.save(entity);
        dto.setModelAnswerId(saved.getModelAnswerId());

        return dto;
    }

    @Override
    public List<ModelAnswerDTO> list() {
        return repository.findAll().stream().map(entity -> {
            ModelAnswerDTO dto = new ModelAnswerDTO();
            dto.setModelAnswerId(entity.getModelAnswerId());
            dto.setContent(entity.getContent());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ModelAnswerDTO findById(Integer id) {
        ModelAnswer entity = repository.findById(id).orElseThrow();

        ModelAnswerDTO dto = new ModelAnswerDTO();
        dto.setModelAnswerId(entity.getModelAnswerId());
        dto.setContent(entity.getContent());

        return dto;
    }

    @Override
    public ModelAnswerDTO update(Integer id, ModelAnswerDTO dto) {
        ModelAnswer entity = repository.findById(id).orElseThrow();
        entity.setContent(dto.getContent());

        ModelAnswer updated = repository.save(entity);
        dto.setModelAnswerId(updated.getModelAnswerId());

        return dto;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
