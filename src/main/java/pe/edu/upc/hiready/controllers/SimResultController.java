package pe.edu.upc.hiready.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.hiready.servicesInterfaces.ISimResultService;

import java.util.List;

@RestController
@RequestMapping("/sim-results")
public class SimResultController {

    private final ISimResultService service;

    public SimResultController(ISimResultService service) {
        this.service = service;
    }

    @GetMapping("/top-candidates")
    public List<Object[]> getTopCandidates() {
        return service.getTopCandidates();
    }

    @GetMapping("/low-technical")
    public List<Object[]> getLowTechnicalUsers() {
        return service.getLowTechnicalUsers();
    }
}