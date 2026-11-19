
package com.covoiturage.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PointArretResponse {

    private Long id;
    private String ville;
    private Integer ordre;
    private LocalDateTime heurePassage;
    private BigDecimal prixDepuisDepart;
    private Long trajetId;
}
