
package com.covoiturage.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TrajetRequest {

    @NotBlank(message = "La ville de depart est obligatoire")
    private String villeDepart;

    @NotBlank(message = "La ville d'arrivee est obligatoire")
    private String villeArrivee;

    @NotNull(message = "La date de depart est obligatoire")
    @Future(message = "La date de depart doit etre dans le futur")
    private LocalDateTime dateDepart;

    @NotNull(message = "Le nombre de places est obligatoire")
    @Min(value = 1, message = "Il faut proposer au moins une place")
    private Integer placesProposees;

    @NotNull(message = "Le conducteur est obligatoire")
    private Long conducteurId;

    @NotNull(message = "Le vehicule est obligatoire")
    private Long vehiculeId;
}
