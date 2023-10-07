package com.br.artour.Service;

import com.br.artour.Entity.Tag;
import com.br.artour.Repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository banco;

    public List<Tag> getAllTag() {return banco.findAll();}
}
