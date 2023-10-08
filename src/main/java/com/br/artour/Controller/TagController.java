package com.br.artour.Controller;


import com.br.artour.Entity.Tag;
import com.br.artour.Model.TagRequest;
import com.br.artour.Service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tag")
public class TagController {
    private TagService service;

    @GetMapping("/all")
    public ResponseEntity<List<Tag>> getAllTag(){ return service.getAllTag();}

    @PostMapping("/create")
    public ResponseEntity<Long> createTag(@RequestBody TagRequest tag){
        return service.createTag(tag);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody TagRequest request){
        return service.updateTag(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        return service.deleteTag(id);
    }
}
