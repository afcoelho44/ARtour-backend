package com.br.artour.Controller;


import com.br.artour.Entity.Tag;
import com.br.artour.Service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TagController {
    private TagService service;

    @GetMapping("/tag")
    public List<Tag> getAllTag(){ return service.getAllTag();}
}
