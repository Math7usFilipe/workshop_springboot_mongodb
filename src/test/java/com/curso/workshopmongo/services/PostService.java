
package com.curso.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.workshopmongo.domain.Post;
import com.curso.workshopmongo.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Optional<Post> findById(String id){
        Optional<Post> post = repo.findById(id);
        
        return post;
    }
    
}