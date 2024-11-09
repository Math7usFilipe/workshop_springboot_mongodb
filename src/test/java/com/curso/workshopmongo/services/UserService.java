package com.curso.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.workshopmongo.domain.User;
import com.curso.workshopmongo.dto.UserDTO;
import com.curso.workshopmongo.repository.UserRepository;
import com.curso.workshopmongo.services.exception.ObjectNOtFoundExcecption;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public Optional<User> findById(String id){
        Optional<User> user = repo.findById(id);
        if(user.isEmpty()){
            throw new ObjectNOtFoundExcecption("Objeto nao encontrado");
        }
        return user;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        repo.deleteById(id);
    }

    public User update(User obj){
        Optional<User> newObj = repo.findById(obj.getId());
        
        if(newObj.isPresent()){
            updateData(newObj.get(), obj);
            return repo.save(newObj.get());
        }
        return obj;
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
