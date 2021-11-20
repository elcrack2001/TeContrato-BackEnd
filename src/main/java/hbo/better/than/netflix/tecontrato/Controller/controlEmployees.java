package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.projectControl;
import hbo.better.than.netflix.tecontrato.domain.service.projectControlService;
import hbo.better.than.netflix.tecontrato.resource.projectControlResource;
import hbo.better.than.netflix.tecontrato.resource.saveProjectControlResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class controlEmployees {
    @Autowired
    private projectControlService projectControlService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/projectcontrol/{projectcontrolId}/employees/{employeesId}")
    public projectControlResource assignProjectControlEmployees(
            @PathVariable Integer projectcontrolId,
            @PathVariable Integer employeesId) {
        return convertToResource(projectControlService.assignProjectControlEmployees(projectcontrolId, employeesId));
    }

    @DeleteMapping("/projectcontrol/{projectcontrolId}/employees/{employeesId}")
    public projectControlResource unassignProjectControlEmployees(
            @PathVariable Integer projectcontrolId,
            @PathVariable Integer employeesId) {
        return convertToResource(projectControlService.unassignProjectControlEmployees(projectcontrolId, employeesId));
    }

    @GetMapping("/employees/{employeesId}/projectcontrol")
    public Page<projectControlResource> getAllProjectControlByEmployeesId(
            @PathVariable Integer employeesId,
            Pageable pageable) {
        Page<projectControl> postsPage = projectControlService.getAllProjectControlByEmployeesId(employeesId, pageable);
        List<projectControlResource> resources = postsPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private projectControl convertToEntity(saveProjectControlResource resource) {
        return mapper.map(resource, projectControl.class);
    }

    private projectControlResource convertToResource(projectControl entity) {
        return mapper.map(entity, projectControlResource.class);
    }
}
