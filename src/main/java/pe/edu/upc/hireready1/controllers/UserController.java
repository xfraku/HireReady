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

    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody UserGeneralDTO dto){
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class); //Convirtiendo User tipo DTO a tipo User (entidad)
        User us = uS.insert(u); //Porque insert() recibe el objeto de tipo User, no el dto

        //Volviendo a convertir a tipo DTO, para dar la respuesta en el frontend (api)
        UserGeneralDTO responseDTO = m.map(us, UserGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
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

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody UserGeneralDTO dto){
        Optional<User> existe = uS.listById(dto.getUserId()); //Pasando el getter para que busque si está el id ingresado

        if (existe.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found.");
        }

        User user = existe.get();
        user.setDni(dto.getDni());
        user.setPersonalEmail(dto.getPersonalEmail());
        user.setPasswordHash(dto.getPasswordHash());
        user.setFirstName(dto.getFirstName());
        user.setSecondName(dto.getSecondName());
        user.setPaternalSurname(dto.getPaternalSurname());
        user.setMaternalSurname(dto.getMaternalSurname());
        user.setLanguagePref(dto.getLanguagePref());

        uS.update(user);

        return ResponseEntity.ok("User successfully updated.");
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
