
package com.covoiturage.service.impl;

import com.covoiturage.dto.request.PassagerRequest;
import com.covoiturage.dto.response.PassagerResponse;
import com.covoiturage.entity.Passager;
import com.covoiturage.mapper.PassagerMapper;
import com.covoiturage.repository.PassagerRepository;
import com.covoiturage.service.PassagerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagerServiceImpl implements PassagerService {

    private final PassagerRepository passagerRepository;
    private final PassagerMapper passagerMapper;

    public PassagerServiceImpl(
            PassagerRepository passagerRepository,
            PassagerMapper passagerMapper) {
        this.passagerRepository = passagerRepository;
        this.passagerMapper = passagerMapper;
    }

    @Override
    public PassagerResponse createPassager(PassagerRequest request) {
        Passager passager = passagerMapper.toEntity(request);

        Passager savedPassager = passagerRepository.save(passager);

        return passagerMapper.toResponse(savedPassager);
    }

    @Override
    public List<PassagerResponse> getAllPassagers() {
        return passagerRepository.findAll()
                .stream()
                .map(passagerMapper::toResponse)
                .toList();
    }

    @Override
    public PassagerResponse getPassagerById(Long id) {
        Passager passager = passagerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Passager introuvable avec ID : " + id));

        return passagerMapper.toResponse(passager);
    }

    @Override
    public PassagerResponse updatePassager(Long id, PassagerRequest request) {
        Passager existingPassager = passagerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Passager introuvable avec ID : " + id));

        Passager updatedPassager = passagerMapper.toEntity(request);
        updatedPassager.setId(existingPassager.getId());

        Passager savedPassager = passagerRepository.save(updatedPassager);

        return passagerMapper.toResponse(savedPassager);
    }

    @Override
    public void deletePassager(Long id) {
        Passager passager = passagerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Passager introuvable avec ID : " + id));

        passagerRepository.delete(passager);
    }
}
