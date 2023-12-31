package com.br.artour.Controller;

import com.br.artour.Entity.User;
import com.br.artour.Model.UserRequest;
import com.br.artour.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
        private UserService service;

        @GetMapping("/all")
        public List<User> getAllUsers(){
            return service.getAllUsers();
        }

        @PostMapping("/create")
        public ResponseEntity<Long> createUser(@RequestBody UserRequest user){
            return service.createUser(user);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequest request){
            return service.updateUser(id, request);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id){
            return service.deleteUser(id);
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
           return service.getUserById(id);
        }


}
