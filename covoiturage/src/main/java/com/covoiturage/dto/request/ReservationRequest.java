
package com.covoiturage.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {

    @NotNull(message = "Le nombre de places est obligatoire")
    @Min(value = 1, message = "Il faut reserver au moins une place")
    private Integer nombrePlaces;

    @NotNull(message = "Le passager est obligatoire")
    private Long passagerId;

    @NotNull(message = "Le trajet est obligatoire")
    private Long trajetId;

    @NotNull(message = "Le point de montee est obligatoire")
    private Long pointMonteeId;

    @NotNull(message = "Le point de descente est obligatoire")
    private Long pointDescenteId;
}
