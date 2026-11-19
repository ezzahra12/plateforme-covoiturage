
package com.covoiturage.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculeRequest {

    @NotBlank(message = "La marque est obligatoire")
    private String marque;

    @NotBlank(message = "Le modele est obligatoire")
    private String modele;

    @NotBlank(message = "L'immatriculation est obligatoire")
    private String immatriculation;

    @NotBlank(message = "La couleur est obligatoire")
    private String couleur;

    @NotNull(message = "La capacite est obligatoire")
    @Min(value = 1, message = "La capacite minimale est 1")
    @Max(value = 8, message = "La capacite maximale est 8")
    private Integer capacite;

    @NotNull(message = "L'identifiant du conducteur est obligatoire")
    private Long conducteurId;
}
