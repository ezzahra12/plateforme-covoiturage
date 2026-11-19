
package com.covoiturage.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PointArretRequest {

    @NotBlank(message = "La ville est obligatoire")
    private String ville;

    @NotNull(message = "L'ordre est obligatoire")
    @Min(value = 1, message = "L'ordre doit etre positif")
    private Integer ordre;

    @NotNull(message = "L'heure de passage est obligatoire")
    private LocalDateTime heurePassage;

    @NotNull(message = "Le prix est obligatoire")
    @DecimalMin(value = "0.0", message = "Le prix doit etre positif ou nul")
    private BigDecimal prixDepuisDepart;

    @NotNull(message = "Le trajet est obligatoire")
    private Long trajetId;
}
