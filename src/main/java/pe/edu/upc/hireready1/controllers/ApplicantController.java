package pe.edu.upc.hireready1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hireready1.dtos.ApplicantGeneralDTO;
import pe.edu.upc.hireready1.entities.Applicant;
import pe.edu.upc.hireready1.servicesinterfaces.IApplicantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    @Autowired
    private IApplicantService aP;

    @GetMapping("/lista-todo")
    public ResponseEntity<List<ApplicantGeneralDTO>> listarTodo(){
        ModelMapper m = new ModelMapper();

        List<ApplicantGeneralDTO> lista = aP.list()
                .stream().map(y -> m.map(y, ApplicantGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody ApplicantGeneralDTO dto){
        ModelMapper m = new ModelMapper();
        Applicant a = m.map(dto, Applicant.class);
        Applicant ap = aP.insert(a);

        ApplicantGeneralDTO responseDTO = m.map(ap, ApplicantGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        ModelMapper m = new ModelMapper();
        Optional<Applicant> applicant = aP.listById(id);

        if (applicant.isPresent()){
            ApplicantGeneralDTO dto = m.map(applicant.get(), ApplicantGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Applicant not found.");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody ApplicantGeneralDTO dto){
        Optional<Applicant> existe = aP.listById(dto.getApplicantId()); //Pasando el getter para que busque si está el id ingresado

        if (existe.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Applicant not found.");
        }

        Applicant applicant = existe.get();
        applicant.setUniversityName(dto.getUniversityName());
        applicant.setUniversityEmail(dto.getUniversityEmail());
        applicant.setUniversityCertificateUrl(dto.getUniversityCertificateUrl());

        aP.update(applicant);

        return ResponseEntity.ok("Applicant successfully updated.");
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        Optional<Applicant> applicant = aP.listById(id); //Primero tiene que encontrar el applicant por id para luego eliminarlo

        if (applicant.isPresent()){
            aP.delete(id);
            return ResponseEntity.ok("Applicant successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Applicant not found.");
        }
    }
}
