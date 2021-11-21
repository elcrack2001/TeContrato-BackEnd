package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.status;
import hbo.better.than.netflix.tecontrato.domain.repository.statusRepository;
import hbo.better.than.netflix.tecontrato.domain.service.statusService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class statusImpl implements statusService {
    @Autowired
    private statusRepository statusRepository;

    @Override
    public Page<status> getAllstatus(Pageable pageable) {
        return statusRepository.findAll(pageable);
    }

    @Override
    public status getstatusById(Integer statusId) {
        return statusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException("status","Id",statusId));
    }

    @Override
    public status createstatus(status status) {
        return statusRepository.save(status);
    }

    @Override
    public status updatestatus(Integer statusId, status statusRequest) {
        status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException("status","Id",statusId));
        return statusRepository.findById(statusId).map(status1 -> {
            status1.setNstatus(statusRequest.getNstatus());
            return  statusRepository.save(status1);
        }).orElseThrow(() -> new ResourceNotFoundException("status id" + statusId));
    }

    @Override
    public ResponseEntity<?> deletestatus(Integer status) {
        status status1 = statusRepository.findById(status)
                .orElseThrow(() -> new ResourceNotFoundException("status","Id",status));
        statusRepository.delete(status1);
        return ResponseEntity.ok().build();
    }
}
