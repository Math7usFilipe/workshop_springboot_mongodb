package com.curso.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")  // O caminho do endpoint
public class UserResource {

    @GetMapping  // Utilizando o @GetMapping, mais específico para requisições GET
    public ResponseEntity<List<User>> findAll() {
        // Criando usuários manualmente
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");

        // Colocando os usuários em uma lista
        List<User> list = Arrays.asList(maria, alex);

        // Retornando a lista de usuários com o código HTTP 200 (OK)
        return ResponseEntity.ok().body(list);
    }
}
