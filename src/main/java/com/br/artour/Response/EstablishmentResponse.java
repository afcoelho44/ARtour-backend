package com.br.artour.Response;

import com.br.artour.Entity.Comentary;
import com.br.artour.Entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EstablishmentResponse {

    private Long id;

    private String name;

    private boolean active;

    private Double latitude;

    private Double longitude;

    private String hour;

    private String attractions;

    private String fees_costs;

    private List<Comentary> comments;

    private String category;

    private List<Tag> tags;

}
