package pe.edu.upc.hireready1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hireready1.dtos.UserGeneralDTO;
import pe.edu.upc.hireready1.entities.User;
import pe.edu.upc.hireready1.servicesinterfaces.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService uS;

    @GetMapping("/lista-todo")
    public ResponseEntity<List<UserGeneralDTO>> listarTodo(){
        ModelMapper m = new ModelMapper();

        List<UserGeneralDTO> lista = uS.list()
                .stream().map(y -> m.map(y, UserGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        ModelMapper m = new ModelMapper();
        Optional<User> user = uS.listById(id);

        if (user.isPresent()){
            UserGeneralDTO dto = m.map(user.get(), UserGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }


    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        Optional<User> user = uS.listById(id); //Primero tiene que encontrar el user por id para luego eliminarlo

        if (user.isPresent()){
            uS.delete(id);
        return ResponseEntity.ok("User successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found.");
        }
    }
}
