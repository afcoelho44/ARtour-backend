package com.br.artour.Mapper;

import com.br.artour.Entity.Category;
import com.br.artour.Model.CategoryRequest;

public class CategoryRequestToEntity implements InternMapper<Category, CategoryRequest>{

    public Category map (CategoryRequest req){
        var record = new Category();

        record.setName(req.getName());

        return record;
    }

    @Override
    public Category mapUpdate(CategoryRequest request, Category record) {
        record.setName(request.getName());

        return record;
    }

}
