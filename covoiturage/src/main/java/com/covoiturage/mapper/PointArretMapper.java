package com.covoiturage.mapper;

import com.covoiturage.dto.request.PointArretRequest;
import com.covoiturage.dto.response.PointArretResponse;
import com.covoiturage.entity.PointArret;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PointArretMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trajet", ignore = true)
    PointArret toEntity(PointArretRequest request);

    @Mapping(source = "trajet.id", target = "trajetId")
    PointArretResponse toResponse(PointArret pointArret);
}