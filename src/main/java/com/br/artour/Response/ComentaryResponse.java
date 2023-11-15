package com.br.artour.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComentaryResponse {

    private Long id;

    private String title;

    private String content;

    private String media;

    private String approved;

    private String user;

    private String establishment;

}
