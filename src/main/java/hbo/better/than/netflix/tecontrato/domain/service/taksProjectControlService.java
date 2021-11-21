package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.taksProjectControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface taksProjectControlService {
    taksProjectControl createTaksProjectControl(Integer projectControlId, Integer employeeId, Integer taskId, taksProjectControl taksProjectControl);
    ResponseEntity<?> deleteTaksProjectControl(Integer taksProjectControlId);
    
    //gets
    Page<taksProjectControl> getAllTaksProjectControl(Pageable pageable);
    taksProjectControl getTaksProjectControlById(Integer taksProjectControlId);
}
