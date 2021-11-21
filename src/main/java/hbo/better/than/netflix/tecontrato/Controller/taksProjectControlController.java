package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.taksProjectControl;
import hbo.better.than.netflix.tecontrato.domain.service.taksProjectControlService;
import hbo.better.than.netflix.tecontrato.resource.taksProjectControlResource;
import hbo.better.than.netflix.tecontrato.resource.saveTaksProjectControlResource;
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
public class taksProjectControlController {
    @Autowired
    private taksProjectControlService taksProjectControlService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"taksprojectcontrols"})
    @GetMapping("/taksprojectcontrols")
    public Page<taksProjectControlResource> getAlltaksProjectControls(Pageable pageable){
        Page<taksProjectControl> userPage = taksProjectControlService.getAllTaksProjectControl(pageable);
        List<taksProjectControlResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"taksprojectcontrols"})
    @GetMapping("/taksprojectcontrols/{taksProjectControlId}")
    public taksProjectControlResource gettaksProjectControlById(@PathVariable Integer taksProjectControlId) {
        return convertToResource(taksProjectControlService.getTaksProjectControlById(taksProjectControlId));
    }

    @Operation(tags={"taksprojectcontrols"})
    @PostMapping("/projectControl/{projectControlId}/employee/{employeesId}/task/{taskId}/taksprojectcontrols")
    public taksProjectControlResource createtaksProjectControl(
            @PathVariable Integer projectControlId,
            @PathVariable Integer employeesId,
            @PathVariable Integer taskId,
            @Valid @RequestBody saveTaksProjectControlResource resource) {
        taksProjectControl taksProjectControl = convertToEntity(resource);
        return convertToResource(taksProjectControlService.createTaksProjectControl(projectControlId,employeesId,taskId,taksProjectControl));
    }

    @Operation(tags={"taksprojectcontrols"})
    @DeleteMapping("/taksprojectcontrols/{taksProjectControlId}")
    public ResponseEntity<?> deletetaksProjectControl(
            @PathVariable Integer taksProjectControlId) {
        return taksProjectControlService.deleteTaksProjectControl(taksProjectControlId);
    }

    private taksProjectControl convertToEntity(saveTaksProjectControlResource resource) {
        return mapper.map(resource, taksProjectControl.class);
    }

    private taksProjectControlResource convertToResource(taksProjectControl entity)
    {
        return mapper.map(entity, taksProjectControlResource.class);
    }
}
