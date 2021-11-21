package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.taksProjectControl;
import hbo.better.than.netflix.tecontrato.domain.repository.*;
import hbo.better.than.netflix.tecontrato.domain.service.taksProjectControlService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class taksProjectControlImpl implements taksProjectControlService {
    @Autowired
    private taksProjectControlRepository taksProjectControlRepository;

    @Autowired
    private projectControlRepository projectControlRepository;

    @Autowired
    private employeesRepository employeesRepository;

    @Autowired
    private taskRepository taskRepository;

    @Override
    public Page<taksProjectControl> getAllTaksProjectControl(Pageable pageable) {
        return taksProjectControlRepository.findAll(pageable);
    }

    @Override
    public taksProjectControl getTaksProjectControlById(Integer taksProjectControlId) {
        return taksProjectControlRepository.findById(taksProjectControlId)
                .orElseThrow(() -> new ResourceNotFoundException("taksProjectControl","Id",taksProjectControlId));
    }

    @Override
    public taksProjectControl createTaksProjectControl(Integer projectControlId, Integer employeeId, Integer taskId, taksProjectControl taksProjectControl) {
        return projectControlRepository.findById(projectControlId).map(projectControl -> {
            taksProjectControl.setProjectControl(projectControl);
            employeesRepository.findById(employeeId).map(employees -> {
                taksProjectControl.setEmployees(employees);
                taskRepository.findById(taskId).map(task -> {
                    taksProjectControl.setTask(task);
                    return taksProjectControlRepository.save(taksProjectControl);
                }).orElseThrow(() -> new ResourceNotFoundException("task Id" + taskId));
                return taksProjectControlRepository.save(taksProjectControl);
            }).orElseThrow(() -> new ResourceNotFoundException("employees Id" + employeeId));
            return taksProjectControlRepository.save(taksProjectControl);
        }).orElseThrow(() -> new ResourceNotFoundException("projectControl Id" + projectControlId));
    }


    @Override
    public ResponseEntity<?> deleteTaksProjectControl(Integer taksProjectControl) {
        taksProjectControl taksProjectControl1 = taksProjectControlRepository.findById(taksProjectControl)
                .orElseThrow(() -> new ResourceNotFoundException("taksProjectControl","Id",taksProjectControl));
        taksProjectControlRepository.delete(taksProjectControl1);
        return ResponseEntity.ok().build();
    }
}


