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

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(Long id){
        return service.getCategoryById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createCategory(@RequestBody CategoryRequest cat){
        return service.createCategory(cat);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request){
        return service.updateCategory(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        return service.DeleteCategory(id);
    }
}
