package pe.edu.upc.hiready.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hiready.dtos.UserDTO;
import pe.edu.upc.hiready.servicesInterfaces.IUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<UserDTO> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
