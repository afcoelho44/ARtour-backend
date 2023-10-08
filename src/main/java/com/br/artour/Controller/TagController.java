package com.br.artour.Controller;


import com.br.artour.Entity.Tag;
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
    public List<Tag> getAllTag(){ return service.getAllTag();}

    @PostMapping("/create")
    public ResponseEntity<Long> createTag(@RequestBody Tag tag){
        return service.createTag(tag);
    }
}
