package com.br.artour.Service;

import com.br.artour.Entity.User;
import com.br.artour.Mapper.UserRequestToEntity;
import com.br.artour.Model.UserRequest;
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

    private UserRepository userRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<Long> createUser(UserRequest request){
        var entity= new UserRequestToEntity().map(request);
        var id = userRepository.save(entity).getId();
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }
    public ResponseEntity<User> updateUser(Long id, UserRequest request){
        var record= userRepository.findById(id).orElseThrow(RuntimeException::new);
        record= new UserRequestToEntity().mapUpdate(request,record);
        userRepository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
