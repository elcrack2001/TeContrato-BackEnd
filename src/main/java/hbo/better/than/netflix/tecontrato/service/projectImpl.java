package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.project;
import hbo.better.than.netflix.tecontrato.domain.repository.budgetRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.clientRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.contractorRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.projectRepository;
import hbo.better.than.netflix.tecontrato.domain.service.projectService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class projectImpl implements projectService {

    @Autowired
    private projectRepository projectRepository;

    @Autowired
    private clientRepository clientRepository;

    @Autowired
    private contractorRepository contractorRepository;

    @Autowired
    private budgetRepository  budgetRepository;
    
    @Override
    public Page<project> getAllproject(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public project getprojectById(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("project","Id",projectId));
    }

    @Override
    public project createproject(Integer clientId, Integer contractorId, Integer budgetId ,project project) {
        return clientRepository.findById(clientId).map(client -> {
            project.setClient(client);
            contractorRepository.findById(contractorId).map(contractor -> {
                project.setContractor(contractor);
                budgetRepository.findById(budgetId).map(budget -> {
                    project.setBudget(budget);
                    return projectRepository.save(project);
                }).orElseThrow(() -> new ResourceNotFoundException("budget Id" + budgetId));
                return projectRepository.save(project);
            }).orElseThrow(() -> new ResourceNotFoundException("contractor Id" + contractorId));
            return projectRepository.save(project);
        }).orElseThrow(() -> new ResourceNotFoundException("client Id" + clientId));
    }

    @Override
    public project updateproject(Integer projectId, project projectRequest) {
        project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("project","Id",projectId));
        return projectRepository.findById(projectId).map(project1 -> {
            project1.setNproject(projectRequest.getNproject())
                    .setCreate_at(projectRequest.getCreate_at())
                    .setTdescription(projectRequest.getTdescription())
                    .setFstatus(projectRequest.getFstatus())
                    .setMbudget(projectRequest.getMbudget());
            return projectRepository.save(project1);
        }).orElseThrow(() -> new ResourceNotFoundException("project id" + projectId));
    }

    @Override
    public ResponseEntity<?> deleteproject(Integer project) {
        project project1 = projectRepository.findById(project)
                .orElseThrow(() -> new ResourceNotFoundException("project","Id",project));
        projectRepository.delete(project1);
        return ResponseEntity.ok().build();
    }
}
