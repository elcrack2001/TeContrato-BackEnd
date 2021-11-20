package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.contractor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface contractorService {
    Page<contractor> getAllContractor(Pageable pageable);
    contractor getContractorById(Integer contractorId);
    contractor createContractor(contractor contractor);
    contractor updateContractor(Integer contractorId, contractor contractorRequest);
    ResponseEntity<?> deleteContractor(Integer contractor);
}
