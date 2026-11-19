package com.covoiturage.mapper;

import com.covoiturage.dto.request.ReservationRequest;
import com.covoiturage.dto.response.ReservationResponse;
import com.covoiturage.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passager", ignore = true)
    @Mapping(target = "trajet", ignore = true)
    @Mapping(target = "pointMontee", ignore = true)
    @Mapping(target = "pointDescente", ignore = true)
    @Mapping(target = "montantTotal", ignore = true)
    @Mapping(target = "dateReservation", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Reservation toEntity(ReservationRequest request);

    @Mapping(source = "passager.id", target = "passagerId")
    @Mapping(source = "trajet.id", target = "trajetId")
    @Mapping(source = "pointMontee.id", target = "pointMonteeId")
    @Mapping(source = "pointDescente.id", target = "pointDescenteId")
    ReservationResponse toResponse(Reservation reservation);
}