package com.br.artour.Controller;


import com.br.artour.Entity.Category;
import com.br.artour.Model.CategoryRequest;
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


    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory(){return service.getAllCategory();}


    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody CategoryRequest cat){
        return service.createCategory(cat);
    }
}
