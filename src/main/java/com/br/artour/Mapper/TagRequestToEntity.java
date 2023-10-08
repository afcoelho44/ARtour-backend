package com.br.artour.Mapper;

import com.br.artour.Entity.Tag;
import com.br.artour.Model.TagRequest;

public class TagRequestToEntity implements InternMapper<Tag, TagRequest> {


    @Override
    public Tag map(TagRequest request) {
        var record = new Tag();

        record.setTitle(request.getTitle());

        return record;
    }

    @Override
    public Tag mapUpdate(TagRequest request, Tag record) {
        record.setTitle(request.getTitle());

        return record;
    }
}
