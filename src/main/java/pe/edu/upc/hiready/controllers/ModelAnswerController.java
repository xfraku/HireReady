package pe.edu.upc.hiready.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hiready.dtos.ModelAnswerDTO;
import pe.edu.upc.hiready.servicesInterfaces.IModelAnswerService;

import java.util.List;

@RestController
@RequestMapping("/model-answers")
public class ModelAnswerController {
    private final IModelAnswerService service;

    public ModelAnswerController(IModelAnswerService service) {
        this.service = service;
    }

    @PostMapping
    public ModelAnswerDTO save(@RequestBody ModelAnswerDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<ModelAnswerDTO> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ModelAnswerDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ModelAnswerDTO update(@PathVariable Integer id, @RequestBody ModelAnswerDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
