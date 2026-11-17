
package com.covoiturage.entity;

import com.covoiturage.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    @Column(nullable = false)
    private Integer nombrePlaces;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private LocalDateTime dateReservation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passager_id", nullable = false)
    private Passager passager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trajet_id", nullable = false)
    private Trajet trajet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_monte_id", nullable = false)
    private PointArret pointMontee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_descente_id", nullable = false)
    private PointArret pointDescente;

}
