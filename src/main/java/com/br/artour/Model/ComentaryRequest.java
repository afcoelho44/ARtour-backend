package com.br.artour.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentaryRequest {
    private Long id;

    private String title;

    private String content;

    private String media;

    private int approved;

    private Long user_id;

    private Long establishment_id;
}