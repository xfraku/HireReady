package pe.edu.upc.hiready.servicesInterfaces;

import pe.edu.upc.hiready.dtos.ModelAnswerDTO;

import java.util.List;

public interface IModelAnswerService {
    ModelAnswerDTO save(ModelAnswerDTO dto);
    List<ModelAnswerDTO> list();
    ModelAnswerDTO findById(Integer id);
    ModelAnswerDTO update(Integer id, ModelAnswerDTO dto);
    void delete(Integer id);
}
