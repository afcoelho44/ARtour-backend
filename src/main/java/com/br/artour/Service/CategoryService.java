package com.br.artour.Service;


import com.br.artour.Entity.Category;
import com.br.artour.Mapper.CategoryRequestToEntity;
import com.br.artour.Model.CategoryRequest;
import com.br.artour.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository repository;


    public ResponseEntity<List<Category>> getAllCategory(){ return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);}

    public ResponseEntity<Category> getCategoryById(Long id){
        var response = repository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Long> createCategory(CategoryRequest request){
        var entity = new CategoryRequestToEntity().map(request);
        var id = repository.save(entity).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    public ResponseEntity<Category> updateCategory(Long id, CategoryRequest request){
        var record = repository.findById(id).orElseThrow(RuntimeException::new);
        record = new CategoryRequestToEntity().mapUpdate(request, record);

        repository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    public ResponseEntity<Void> DeleteCategory(Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
