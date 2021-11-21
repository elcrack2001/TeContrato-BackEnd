package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface statusService {
    Page<status> getAllstatus(Pageable pageable);
    status getstatusById(Integer statusId);
    status createstatus(status status);
    status updatestatus(Integer statusId, status statusRequest);
    ResponseEntity<?> deletestatus(Integer status);
}
