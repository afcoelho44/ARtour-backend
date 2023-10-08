package com.br.artour.Service;

import com.br.artour.Entity.Establishment;
import com.br.artour.Repository.EstablishmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstablishmentService {

    private EstablishmentRepository repository;

    public List<Establishment> getAllEstablishment(){return repository.findAll();}

    public ResponseEntity<Long> createEstablishment(Establishment est){
        var id = repository.save(est).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
