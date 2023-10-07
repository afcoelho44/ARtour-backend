package com.br.artour.Service;


import com.br.artour.Entity.Category;
import com.br.artour.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository banco;


    public List<Category> getAllCategory(){ return banco.findAll();}

    //public ResponseEntity<Long>
}
