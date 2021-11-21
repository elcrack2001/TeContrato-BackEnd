package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.employees;
import hbo.better.than.netflix.tecontrato.domain.model.projectControl;
import hbo.better.than.netflix.tecontrato.domain.repository.employeesRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.projectControlRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.projectRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.statusRepository;
import hbo.better.than.netflix.tecontrato.domain.service.projectControlService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class projectControlmpl implements projectControlService {
    @Autowired
    private projectControlRepository projectControlRepository;
    
    @Autowired
    private projectRepository projectRepository;

    @Autowired
    private statusRepository statusRepository;

    @Autowired
    private employeesRepository employeesRepository;
    
    @Override
    public Page<projectControl> getAllprojectControl(Pageable pageable) {
        return projectControlRepository.findAll(pageable);
    }

    @Override
    public projectControl getprojectControlById(Integer projectControlId) {
        return projectControlRepository.findById(projectControlId)
                .orElseThrow(() -> new ResourceNotFoundException("projectControl","Id",projectControlId));
    }

    @Override
    public projectControl createprojectControl(Integer projectId, Integer statusId, projectControl projectControl) {
        return projectRepository.findById(projectId).map(project -> {
            projectControl.setProject(project);
            statusRepository.findById(statusId).map(status -> {
                projectControl.setStatus(status);
                return projectControlRepository.save(projectControl);
            }).orElseThrow(() -> new ResourceNotFoundException("status Id" + statusId));
            return projectControlRepository.save(projectControl);
        }).orElseThrow(() -> new ResourceNotFoundException("project Id" + projectId));
    }

    @Override
    public projectControl updateprojectControl(Integer projectControlId, projectControl projectControlRequest) {
        projectControl projectControl = projectControlRepository.findById(projectControlId)
                .orElseThrow(() -> new ResourceNotFoundException("projectControl","Id",projectControlId));
        return projectControlRepository.findById(projectControlId).map(projectControl1 -> {
            projectControl1.setNproyect(projectControlRequest.getNproyect())
                    .setFstatus(projectControlRequest.getFstatus())
                    .setDlastedited(projectControlRequest.getDlastedited())
                    .setTtasks(projectControlRequest.getTtasks())
                    .setQemployees(projectControlRequest.getQemployees())
                    .setMbudget(projectControlRequest.getMbudget())
                    .setQprogress(projectControlRequest.getQprogress());
            return projectControlRepository.save(projectControl1);
        }).orElseThrow(() -> new ResourceNotFoundException("projectControl id" + projectControlId));
    }

    @Override
    public ResponseEntity<?> deleteprojectControl(Integer projectControl) {
        projectControl projectControl1 = projectControlRepository.findById(projectControl)
                .orElseThrow(() -> new ResourceNotFoundException("projectControl","Id",projectControl));
        projectControlRepository.delete(projectControl1);
        return ResponseEntity.ok().build();
    }

    @Override
    public projectControl assignProjectControlEmployees(Integer projectControlId, Integer employeesId) {
        employees employees = employeesRepository.findById(employeesId)
                .orElseThrow(() -> new ResourceNotFoundException("Employees", "Id", employeesId));
        return projectControlRepository.findById(projectControlId).map(
                        post -> projectControlRepository.save(post.tagWith(employees)))
                .orElseThrow(() -> new ResourceNotFoundException("Project Control", "Id", projectControlId));
    }

    @Override
    public projectControl unassignProjectControlEmployees(Integer projectControlId, Integer employeesId) {
        employees employees = employeesRepository.findById(employeesId)
                .orElseThrow(() -> new ResourceNotFoundException("Employees", "Id", employeesId));
        return projectControlRepository.findById(projectControlId).map(
                        post -> projectControlRepository.save(post.untagWith(employees)))
                .orElseThrow(() -> new ResourceNotFoundException("Project Control", "Id", projectControlId));
    }

    @Override
    public Page<projectControl> getAllProjectControlByEmployeesId(Integer employeesId, Pageable pageable) {
        return employeesRepository.findById(employeesId).map(tag -> {
                    List<projectControl> posts = tag.getProjectControls();
                    int postsCount = posts.size();
                    return new PageImpl<>(posts, pageable, postsCount); })
                .orElseThrow(() -> new ResourceNotFoundException("Employees", "Id", employeesId));
    }
}
