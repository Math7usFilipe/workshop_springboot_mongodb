package com.curso.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshopmongo.domain.User;
import com.curso.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")  // O caminho do endpoint
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping  // Utilizando o @GetMapping, mais específico para requisições GET
    public ResponseEntity<List<User>> findAll() {
        // Criando usuários manualmente
        

        // Colocando os usuários em uma lista
        List<User> list = service.findAll();

        // Retornando a lista de usuários com o código HTTP 200 (OK)
        return ResponseEntity.ok().body(list);
    }
}
