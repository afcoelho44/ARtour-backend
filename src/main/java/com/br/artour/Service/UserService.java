package com.br.artour.Service;

import com.br.artour.Entity.User;
import com.br.artour.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {

    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public ResponseEntity<Long> createUser(User user){
        Long id = repository.save(user).getId();
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }
}
