package com.br.artour.Controller;


import com.br.artour.Entity.Comentary;
import com.br.artour.Model.ComentaryRequest;
import com.br.artour.Response.ComentaryResponse;
import com.br.artour.Service.ComentaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comentary")
@CrossOrigin(origins = "*")
public class ComentaryController {

    private ComentaryService service;

    @GetMapping("/all")
    public List<ComentaryResponse> getAllComentary(){return service.getAllComentary();}

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

    @GetMapping("/{id}")
    public ResponseEntity<ComentaryResponse> getComentaryById(@PathVariable("id") Long id){
        return service.getComentaryById(id);
    }

    @PatchMapping("/approved/{id}")
    public ResponseEntity<Void> setApprovedComentary(@PathVariable("id") Long id, @RequestBody Integer approved){
        return service.setApprovedComentary(id, approved);
    }
}
