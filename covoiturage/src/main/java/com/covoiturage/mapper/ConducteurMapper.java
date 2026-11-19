package com.covoiturage.mapper;

import com.covoiturage.dto.request.ConducteurRequest;
import com.covoiturage.dto.response.ConducteurResponse;
import com.covoiturage.entity.Conducteur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConducteurMapper {

    Conducteur toEntity(ConducteurRequest request);

    ConducteurResponse toResponse(Conducteur conducteur);
}