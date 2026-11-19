package com.covoiturage.mapper;

import com.covoiturage.dto.request.VehiculeRequest;
import com.covoiturage.dto.response.VehiculeResponse;
import com.covoiturage.entity.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "conducteur", ignore = true)
    Vehicule toEntity(VehiculeRequest request);

    @Mapping(source = "conducteur.id", target = "conducteurId")
    VehiculeResponse toResponse(Vehicule vehicule);
}