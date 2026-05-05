package pe.edu.upc.hiready.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hiready.dtos.RolDTO;
import pe.edu.upc.hiready.servicesInterfaces.IRolService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    private final IRolService rolService;

    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public RolDTO save(@RequestBody RolDTO dto) {
        return rolService.save(dto);
    }

    @GetMapping
    public List<RolDTO> list() {
        return rolService.list();
    }

    @PutMapping("/{id}")
    public RolDTO update(@PathVariable Integer id, @RequestBody RolDTO dto) {
        return rolService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rolService.delete(id);
    }
}
