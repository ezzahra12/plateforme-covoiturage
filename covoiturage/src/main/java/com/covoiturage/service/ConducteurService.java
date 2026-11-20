
package com.covoiturage.service;

import com.covoiturage.dto.request.ConducteurRequest;
import com.covoiturage.dto.response.ConducteurResponse;
import com.covoiturage.entity.Conducteur;
import com.covoiturage.mapper.ConducteurMapper;
import com.covoiturage.repository.ConducteurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurService {

    private final ConducteurRepository conducteurRepository;
    private final ConducteurMapper conducteurMapper;

    public ConducteurService(
            ConducteurRepository conducteurRepository,
            ConducteurMapper conducteurMapper) {
        this.conducteurRepository = conducteurRepository;
        this.conducteurMapper = conducteurMapper;
    }


    public ConducteurResponse createConducteur(ConducteurRequest request) {

        Conducteur conducteur = conducteurMapper.toEntity(request);

        Conducteur savedConducteur =
                conducteurRepository.save(conducteur);

        return conducteurMapper.toResponse(savedConducteur);
    }


    public List<ConducteurResponse> getAllConducteurs() {

        return conducteurRepository.findAll()
                .stream()
                .map(conducteurMapper::toResponse)
                .toList();
    }


    public ConducteurResponse getConducteurById(Long id) {

        Conducteur conducteur = conducteurRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Conducteur introuvable avec ID : " + id
                        ));

        return conducteurMapper.toResponse(conducteur);
    }


    public ConducteurResponse updateConducteur(
            Long id,
            ConducteurRequest request) {

        Conducteur existingConducteur =
                conducteurRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException(
                                        "Conducteur introuvable avec ID : " + id
                                ));

        Conducteur updatedConducteur =
                conducteurMapper.toEntity(request);

        updatedConducteur.setId(existingConducteur.getId());

        Conducteur savedConducteur =
                conducteurRepository.save(updatedConducteur);

        return conducteurMapper.toResponse(savedConducteur);
    }


    public void deleteConducteur(Long id) {

        Conducteur conducteur = conducteurRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Conducteur introuvable avec ID : " + id
                        ));

        conducteurRepository.delete(conducteur);
    }
}
