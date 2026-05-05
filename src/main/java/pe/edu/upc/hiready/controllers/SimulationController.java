package pe.edu.upc.hiready.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hiready.dtos.*;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.repositories.UserRepository;
import pe.edu.upc.hiready.servicesInterfaces.ISimulationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/simulations")
public class SimulationController {

    private final ISimulationService simulationService;
    private final UserRepository userRepository;

    public SimulationController(ISimulationService simulationService, UserRepository userRepository) {
        this.simulationService = simulationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/start")
    public ResponseEntity<SimulationDTO> start(@Valid @RequestBody SimulationStartRequest request,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(simulationService.startSimulation(user.getUserId(), request));
    }

    @PostMapping("/{id}/answer")
    public ResponseEntity<SimulationDTO> answer(@PathVariable Integer id,
                                                @Valid @RequestBody AnswerRequest request) {
        return ResponseEntity.ok(simulationService.answerQuestion(id, request));
    }

    @GetMapping("/{id}/hint/{questionId}")
    public ResponseEntity<Map<String, String>> hint(@PathVariable Integer id,
                                                    @PathVariable Integer questionId) {
        String hint = simulationService.getHint(id, questionId);
        return ResponseEntity.ok(Map.of("hint", hint));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<SimResultDTO> complete(@PathVariable Integer id) {
        return ResponseEntity.ok(simulationService.completeSimulation(id));
    }

    @PostMapping("/{id}/resume")
    public ResponseEntity<SimulationDTO> resume(@PathVariable Integer id) {
        return ResponseEntity.ok(simulationService.resumeSimulation(id));
    }

    @GetMapping("/my")
    public ResponseEntity<List<SimulationDTO>> mySimulations(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(simulationService.getUserSimulations(user.getUserId()));
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<SimResultDTO> result(@PathVariable Integer id) {
        return ResponseEntity.ok(simulationService.getSimulationResult(id));
    }
}
