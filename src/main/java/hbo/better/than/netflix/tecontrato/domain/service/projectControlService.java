package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.projectControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface projectControlService {
    Page<projectControl> getAllprojectControl(Pageable pageable);
    projectControl getprojectControlById(Integer projectControlId);
    projectControl createprojectControl(Integer projectId, Integer statusId, projectControl projectControl);
    projectControl updateprojectControl(Integer projectControlId, projectControl projectControlRequest);
    ResponseEntity<?> deleteprojectControl(Integer projectControl);

    projectControl assignProjectControlEmployees(Integer projectControlId, Integer employeesId);
    projectControl unassignProjectControlEmployees(Integer projectControlId, Integer employeesId);
    Page<projectControl> getAllProjectControlByEmployeesId(Integer employeesId, Pageable pageable);
}
