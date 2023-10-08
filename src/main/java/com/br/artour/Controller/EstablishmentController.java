package com.br.artour.Controller;


import com.br.artour.Entity.Establishment;
import com.br.artour.Entity.User;
import com.br.artour.Model.EstablishmentRequest;
import com.br.artour.Model.UserRequest;
import com.br.artour.Service.EstablishmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/establishment")
public class EstablishmentController {

    private EstablishmentService service;

    @GetMapping("/all")
    public List<Establishment> getAllEstablishment(){return service.getAllEstablishment();}


    @PostMapping("/create")
    public ResponseEntity<Long> createEstablishment(@RequestBody EstablishmentRequest establishmentRequest){
        return service.createEstablishment(establishmentRequest);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Establishment> updateEstablishment(@PathVariable Long id, @RequestBody EstablishmentRequest request){
        return service.updateEstablishment(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEstablishment(@PathVariable Long id){
        return service.deleteEstablishment(id);
    }
}
