package com.br.artour.Service;

import com.br.artour.Entity.Establishment;
import com.br.artour.Mapper.EstablishmentRequestToEntity;
import com.br.artour.Model.EstablishmentRequest;
import com.br.artour.Repository.CategoryRepository;
import com.br.artour.Repository.EstablishmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstablishmentService {

    private EstablishmentRepository repositoryEstablishment;

    private CategoryRepository categoryRepository;

    public List<Establishment> getAllEstablishment(){return repositoryEstablishment.findAll();}

    public ResponseEntity<Long> createEstablishment(EstablishmentRequest establishmentRequest){
        var category= categoryRepository.findById(establishmentRequest.getCategory_id()).orElseThrow(RuntimeException::new);
        var entity= new EstablishmentRequestToEntity().map(establishmentRequest);
        entity.setCategory(category);

        var id = repositoryEstablishment.save(entity).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
