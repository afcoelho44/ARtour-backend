package com.br.artour.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentRequest {
    private Long id;

    private String name;

    private boolean active;

    private Double latitude;

    private Double longitude;

    private LocalTime hour;

    private String attractions;

    private String fees_costs;

    private Long category_id;
}
