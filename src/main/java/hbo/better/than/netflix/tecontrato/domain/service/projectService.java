package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface projectService {
    Page<project> getAllproject(Pageable pageable);
    project getprojectById(Integer projectId);
    project createproject(Integer clientId, Integer contractorId, Integer budgetId ,project project);
    project updateproject(Integer projectId, project projectRequest);
    ResponseEntity<?> deleteproject(Integer project);
}
