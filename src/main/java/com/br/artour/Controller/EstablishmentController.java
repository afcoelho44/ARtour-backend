package com.br.artour.Controller;


import com.br.artour.Entity.Establishment;
import com.br.artour.Service.EstablishmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EstablishmentController {

    private EstablishmentService service;

    @GetMapping("/establishment")
    public List<Establishment> getAllEstablishment(){return service.getAllEstablishment();}
}
