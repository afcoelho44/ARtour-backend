package com.br.artour.Controller;


import com.br.artour.Entity.Comentary;
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
    public ResponseEntity<Long> createComentary(@RequestBody Comentary comentary){
        return service.createComentery(comentary);
    }
}
