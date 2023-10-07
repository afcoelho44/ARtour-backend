package com.br.artour.Controller;


import com.br.artour.Entity.Comentary;
import com.br.artour.Service.ComentaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ComentaryController {

    private ComentaryService service;

    @GetMapping("/comentary")
    public List<Comentary> getAllComentary(){return service.getAllComentary();}
}
