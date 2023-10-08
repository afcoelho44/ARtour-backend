package com.br.artour.Service;

import com.br.artour.Entity.Comentary;
import com.br.artour.Repository.ComentaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComentaryService {

    private ComentaryRepository repository;

    public List<Comentary> getAllComentary(){return repository.findAll();}

    public ResponseEntity<Long> createComentery(Comentary com){
        var id = repository.save(com).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
