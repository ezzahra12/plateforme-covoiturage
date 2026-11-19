
package com.covoiturage.dto.response;

import com.covoiturage.enums.StatutTrajet;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TrajetResponse {

    private Long id;
    private String villeDepart;
    private String villeArrivee;
    private LocalDateTime dateDepart;
    private Integer placesProposees;
    private StatutTrajet statut;
    private Long conducteurId;
    private Long vehiculeId;
}
