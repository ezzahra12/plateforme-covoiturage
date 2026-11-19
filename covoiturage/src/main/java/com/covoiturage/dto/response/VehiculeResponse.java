
package com.covoiturage.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculeResponse {

    private Long id;
    private String marque;
    private String modele;
    private String immatriculation;
    private String couleur;
    private Integer capacite;
    private Long conducteurId;
}
