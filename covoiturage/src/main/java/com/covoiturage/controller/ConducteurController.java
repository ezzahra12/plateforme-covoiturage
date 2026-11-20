
package com.covoiturage.controller;

import com.covoiturage.dto.request.ConducteurRequest;
import com.covoiturage.dto.response.ConducteurResponse;
import com.covoiturage.service.ConducteurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conducteurs")
public class ConducteurController {

    private final ConducteurService conducteurService;

    public ConducteurController(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConducteurResponse create(
            @Valid @RequestBody ConducteurRequest request) {
        return conducteurService.createConducteur(request);
    }

    @GetMapping
    public List<ConducteurResponse> findAll() {
        return conducteurService.getAllConducteurs();
    }

    @GetMapping("/{id}")
    public ConducteurResponse findById(@PathVariable Long id) {
        return conducteurService.getConducteurById(id);
    }

    @PutMapping("/{id}")
    public ConducteurResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ConducteurRequest request) {
        return conducteurService.updateConducteur(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        conducteurService.deleteConducteur(id);
    }
}
