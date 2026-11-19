package com.covoiturage.mapper;

import com.covoiturage.dto.request.TrajetRequest;
import com.covoiturage.dto.response.TrajetResponse;
import com.covoiturage.entity.Trajet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrajetMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "conducteur", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "pointsArret", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Trajet toEntity(TrajetRequest request);

    @Mapping(source = "conducteur.id", target = "conducteurId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    TrajetResponse toResponse(Trajet trajet);
}