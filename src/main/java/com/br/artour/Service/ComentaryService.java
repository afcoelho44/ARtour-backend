package com.br.artour.Service;

import com.br.artour.Entity.Comentary;
import com.br.artour.Repository.ComentaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComentaryService {

    private ComentaryRepository banco;

    public List<Comentary> getAllComentary(){return banco.findAll();}
}
