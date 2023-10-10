package com.br.artour.Service;

import com.br.artour.Entity.Establishment;
import com.br.artour.Entity.Tag;
import com.br.artour.Exception.EstablishmentNotFoundException;
import com.br.artour.Mapper.TagRequestToEntity;
import com.br.artour.Model.TagRequest;
import com.br.artour.Repository.EstablishmentRepository;
import com.br.artour.Repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository repository;

    private EstablishmentRepository establishmentRepository;

    public ResponseEntity<List<Tag>> getAllTag() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Long> createTag(TagRequest request){
        var entity = new TagRequestToEntity().map(request);

        try{
            var establishment= establishmentRepository.findById(request.getEstablishment_id()).orElseThrow(EstablishmentNotFoundException::new);
            establishment.getTags().add(entity);

        } catch (EstablishmentNotFoundException e){
             System.out.println(e.getMessage());
        }

        var id = repository.save(entity).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    public ResponseEntity<Tag> updateTag(Long id, TagRequest request){
        var record = repository.findById(id).orElseThrow(RuntimeException::new);

        try{
            var establishment= establishmentRepository.findById(request.getEstablishment_id()).orElseThrow(EstablishmentNotFoundException::new);
            establishment.getTags().add(record);
        } catch (EstablishmentNotFoundException e){
            System.out.println(e.getMessage());
        }

        record = new TagRequestToEntity().mapUpdate(request, record);

        repository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteTag(Long id){
        var tag= repository.findById(id).orElseThrow(RuntimeException::new);
        var establishments = tag.getEstablishments();

        establishments.forEach(establishment -> establishment.removeTag(tag));

        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
