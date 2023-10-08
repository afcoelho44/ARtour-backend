package com.br.artour.Mapper;

import com.br.artour.Entity.Comentary;
import com.br.artour.Model.ComentaryRequest;

public class ComentaryRequestToEntity implements InternMapper<Comentary, ComentaryRequest>{
    @Override
    public Comentary map(ComentaryRequest request) {
        var record= new Comentary();

        record.setTitle(request.getTitle());
        record.setContent(request.getContent());
        record.setMedia(request.getMedia());

        return record;
    }

    @Override
    public Comentary mapUpdate(ComentaryRequest request, Comentary record) {
        record.setTitle(request.getTitle());
        record.setContent(request.getContent());
        record.setMedia(request.getMedia());

        return record;
    }
}
