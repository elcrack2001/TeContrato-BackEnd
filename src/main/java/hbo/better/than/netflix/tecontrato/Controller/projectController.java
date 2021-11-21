package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.project;
import hbo.better.than.netflix.tecontrato.domain.service.projectService;
import hbo.better.than.netflix.tecontrato.resource.projectResource;
import hbo.better.than.netflix.tecontrato.resource.saveProjectResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class projectController {
    @Autowired
    private projectService projectService;
    
    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"projects"})
    @GetMapping("/projects")
    public Page<projectResource> getAllprojects(Pageable pageable){
        Page<project> userPage = projectService.getAllproject(pageable);
        List<projectResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"projects"})
    @GetMapping("/projects/{projectId}")
    public projectResource getprojectById(@PathVariable Integer projectId) {
        return convertToResource(projectService.getprojectById(projectId));
    }

    @Operation(tags={"projects"})
    @PostMapping("/client/{clientid}/contractor/{contractorid}/budget/{budgetid}/projects")
    public projectResource createproject(
            @PathVariable Integer clientid,
            @PathVariable Integer contractorid,
            @PathVariable Integer budgetid,
            @Valid @RequestBody saveProjectResource resource) {
        project project = convertToEntity(resource);
        return convertToResource(projectService.createproject(clientid,contractorid,budgetid,project));
    }

    @Operation(tags={"projects"})
    @PutMapping("/projects/{projectId}")
    public projectResource updateproject(@PathVariable Integer projectId, @Valid @RequestBody saveProjectResource resource) {
        project project = convertToEntity(resource);
        return convertToResource(projectService.updateproject(projectId, project));
    }

    @Operation(tags={"projects"})
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<?> deleteProject(
            @PathVariable Integer projectId) {
        return projectService.deleteproject(projectId);
    }


    private project convertToEntity(saveProjectResource resource) {
        return mapper.map(resource, project.class);
    }

    private projectResource convertToResource(project entity)
    {
        return mapper.map(entity, projectResource.class);
    }
    
}
