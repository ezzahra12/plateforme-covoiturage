
package com.covoiturage.dto.response;

import com.covoiturage.enums.StatutReservation;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponse {

    private Long id;
    private Integer nombrePlaces;
    private BigDecimal montantTotal;
    private LocalDateTime dateReservation;
    private StatutReservation statut;

    private Long passagerId;
    private Long trajetId;
    private Long pointMonteeId;
    private Long pointDescenteId;
}
