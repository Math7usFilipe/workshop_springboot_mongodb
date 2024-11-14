package com.curso.workshopmongo.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshopmongo.domain.Post;
import com.curso.workshopmongo.services.PostService;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        
        Optional<Post> obj = service.findById(id);

        if(obj.isPresent()){
            return ResponseEntity.ok().body(obj.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
        
    }
    
}