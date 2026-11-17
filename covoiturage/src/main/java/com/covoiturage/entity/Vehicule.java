
package com.covoiturage.entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicules")
@Getter
@Setter
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String modele;

    @Column(nullable = false, unique = true)
    private String immatriculation;

    @Column(nullable = false)
    private String couleur;

    @Min(1)
    @Max(8)
    @Column(nullable = false)
    private Integer capacite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conducteur_id", nullable = false)
    private Conducteur conducteur;
}
