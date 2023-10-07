package com.br.artour.Controller;


import com.br.artour.Entity.Category;
import com.br.artour.Repository.CategoryRepository;
import com.br.artour.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService service;

    private CategoryRepository r;

    @GetMapping("/all")
    public List<Category> getAllCategory(){return service.getAllCategory();}


    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody Category cat){
        Long id= r.save(cat).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
