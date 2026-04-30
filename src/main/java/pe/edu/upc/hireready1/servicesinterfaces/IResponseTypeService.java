package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.ResponseType;

import java.util.List;
import java.util.Optional;

public interface IResponseTypeService {
    public ResponseType insert(ResponseType r);
    public List<ResponseType> list();
    public Optional<ResponseType> listById(Long id);
    public void update(ResponseType r);
    public void delete(Long id);
}
