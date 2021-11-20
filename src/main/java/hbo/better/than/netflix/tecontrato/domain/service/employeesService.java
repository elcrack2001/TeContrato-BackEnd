package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface employeesService {
    Page<employees> getAllemployees(Pageable pageable);
    employees getemployeesById(Integer employeesId);
    employees createemployees(Integer jobId, employees employees);
    employees updateemployees(Integer employeesId, employees employeesRequest);
    ResponseEntity<?> deleteemployees(Integer employees);
}
