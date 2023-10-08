package com.br.artour.Service;


import com.br.artour.Entity.Category;
import com.br.artour.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository repository;


    public List<Category> getAllCategory(){ return repository.findAll();}

    public ResponseEntity<Long> createCategory(Category category){
        var id = repository.save(category).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
