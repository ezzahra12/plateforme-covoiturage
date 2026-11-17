
package com.covoiturage.entity;

import com.covoiturage.enums.StatutTrajet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "trajets")
@Getter
@Setter
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String villeDepart;

    @Column(nullable = false)
    private String villeArrivee;

    @Column(nullable = false)
    private LocalDateTime dateDepart;

    @Column(nullable = false)
    private Integer placesProposees;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutTrajet statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conducteur_id", nullable = false)
    private Conducteur conducteur;

    @OneToMany(
            mappedBy = "trajet",
            cascade = CascadeType.ALL
    )
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;
    @OneToMany(
            mappedBy = "trajet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("ordre ASC")
    private List<PointArret> pointsArret = new ArrayList<>();
}
