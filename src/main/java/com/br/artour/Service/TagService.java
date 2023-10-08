package com.br.artour.Service;

import com.br.artour.Entity.Tag;
import com.br.artour.Repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository repository;

    public List<Tag> getAllTag() {return repository.findAll();}

    public ResponseEntity<Long> createTag(Tag tag){
        var id = repository.save(tag).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
