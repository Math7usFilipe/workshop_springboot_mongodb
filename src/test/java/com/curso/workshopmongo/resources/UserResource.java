package com.curso.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshopmongo.domain.User;
import com.curso.workshopmongo.dto.UserDTO;
import com.curso.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")  // O caminho do endpoint
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping  // Utilizando o @GetMapping, mais específico para requisições GET
    public ResponseEntity<List<UserDTO>> findAll() {
        // Criando usuários manualmente
        // Colocando os usuários em uma lista
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        // Retornando a lista de usuários com o código HTTP 200 (OK)
        return ResponseEntity.ok().body(listDto);        
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)  // Utilizando o @GetMapping, mais específico para requisições GET
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<User> obj = service.findById(id);
        
        if(obj.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        UserDTO userDTO = new UserDTO(obj.get());

        return ResponseEntity.ok().body(userDTO);

    }
}
