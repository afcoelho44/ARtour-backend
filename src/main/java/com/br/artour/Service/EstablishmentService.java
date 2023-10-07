package com.br.artour.Service;

import com.br.artour.Entity.Establishment;
import com.br.artour.Repository.EstablishmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstablishmentService {

    private EstablishmentRepository banco;

    public List<Establishment> getAllEstablishment(){return banco.findAll();}
}
