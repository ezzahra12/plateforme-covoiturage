
package com.covoiturage.controller;

import com.covoiturage.dto.request.PassagerRequest;
import com.covoiturage.dto.response.PassagerResponse;
import com.covoiturage.service.PassagerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passagers")
public class PassagerController {

    private final PassagerService passagerService;

    public PassagerController(PassagerService passagerService) {
        this.passagerService = passagerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassagerResponse create(@Valid @RequestBody PassagerRequest request) {
        return passagerService.createPassager(request);
    }

    @GetMapping
    public List<PassagerResponse> findAll() {
        return passagerService.getAllPassagers();
    }

    @GetMapping("/{id}")
    public PassagerResponse findById(@PathVariable Long id) {
        return passagerService.getPassagerById(id);
    }

    @PutMapping("/{id}")
    public PassagerResponse update(
            @PathVariable Long id,
            @Valid @RequestBody PassagerRequest request) {
        return passagerService.updatePassager(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        passagerService.deletePassager(id);
    }
}
