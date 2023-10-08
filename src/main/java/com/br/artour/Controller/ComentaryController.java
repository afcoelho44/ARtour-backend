package com.br.artour.Controller;


import com.br.artour.Entity.Comentary;
import com.br.artour.Entity.User;
import com.br.artour.Model.ComentaryRequest;
import com.br.artour.Model.UserRequest;
import com.br.artour.Service.ComentaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comentary")
public class ComentaryController {

    private ComentaryService service;

    @GetMapping("/all")
    public List<Comentary> getAllComentary(){return service.getAllComentary();}

    @PostMapping("/create")
    public ResponseEntity<Long> createComentary(@RequestBody ComentaryRequest comentaryRequest){
        return service.createComentery(comentaryRequest);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Comentary> updateComentary(@PathVariable Long id, @RequestBody ComentaryRequest request){
        return service.updateComentary(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComentary(@PathVariable Long id){
        return service.deleteComentary(id);
    }
}
