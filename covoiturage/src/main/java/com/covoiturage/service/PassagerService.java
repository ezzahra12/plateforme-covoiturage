
package com.covoiturage.service;

import com.covoiturage.dto.request.PassagerRequest;
import com.covoiturage.dto.response.PassagerResponse;

import java.util.List;

public interface PassagerService {

    PassagerResponse createPassager(PassagerRequest request);

    List<PassagerResponse> getAllPassagers();

    PassagerResponse getPassagerById(Long id);

    PassagerResponse updatePassager(Long id, PassagerRequest request);

    void deletePassager(Long id);
}
