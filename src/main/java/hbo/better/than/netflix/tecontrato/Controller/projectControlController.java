package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.projectControl;
import hbo.better.than.netflix.tecontrato.domain.service.projectControlService;
import hbo.better.than.netflix.tecontrato.resource.projectControlResource;
import hbo.better.than.netflix.tecontrato.resource.saveProjectControlResource;
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
public class projectControlController {
    @Autowired
    private projectControlService projectControlService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"projectControls"})
    @GetMapping("/projectControls")
    public Page<projectControlResource> getAllprojectControls(Pageable pageable){
        Page<projectControl> userPage = projectControlService.getAllprojectControl(pageable);
        List<projectControlResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"projectControls"})
    @GetMapping("/projectControls/{projectControlId}")
    public projectControlResource getprojectControlById(@PathVariable Integer projectControlId) {
        return convertToResource(projectControlService.getprojectControlById(projectControlId));
    }

    @Operation(tags={"projectControls"})
    @PostMapping("/project/{projectid}/status/{statusId}/projectControls")
    public projectControlResource createprojectControl(
            @PathVariable Integer projectid,
            @PathVariable Integer statusId,
            @Valid @RequestBody saveProjectControlResource resource) {
        projectControl projectControl = convertToEntity(resource);
        return convertToResource(projectControlService.createprojectControl(projectid, statusId, projectControl));
    }

    @Operation(tags={"projectControls"})
    @PutMapping("/projectControls/{projectControlId}")
    public projectControlResource updateprojectControl(@PathVariable Integer projectControlId,
                                                       @Valid @RequestBody saveProjectControlResource resource) {
        projectControl projectControl = convertToEntity(resource);
        return convertToResource(projectControlService.updateprojectControl(projectControlId, projectControl));
    }

    @Operation(tags={"projectControls"})
    @DeleteMapping("/projectControls/{projectControlId}")
    public ResponseEntity<?> deleteProjectControl(
            @PathVariable Integer projectControlId) {
        return projectControlService.deleteprojectControl(projectControlId);
    }


    private projectControl convertToEntity(saveProjectControlResource resource) {
        return mapper.map(resource, projectControl.class);
    }

    private projectControlResource convertToResource(projectControl entity)
    {
        return mapper.map(entity, projectControlResource.class);
    }
}
