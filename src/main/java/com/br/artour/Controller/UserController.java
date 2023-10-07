package com.br.artour.Controller;

import com.br.artour.Entity.User;
import com.br.artour.Repository.UserRepository;
import com.br.artour.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
        private UserService service;

        @GetMapping("/all")
        public List<User> getAllUsers(){
            return service.getAllUsers();
        }

        @PostMapping("/create")
        public ResponseEntity<Long> createUser(@RequestBody User user){
            return service.createUser(user);
        }
}
