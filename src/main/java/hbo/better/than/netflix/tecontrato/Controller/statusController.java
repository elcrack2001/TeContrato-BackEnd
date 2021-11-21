package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.status;
import hbo.better.than.netflix.tecontrato.domain.service.statusService;
import hbo.better.than.netflix.tecontrato.resource.statusResource;
import hbo.better.than.netflix.tecontrato.resource.saveStatusResource;
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
public class statusController {
    @Autowired
    private statusService statusService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"status"})
    @GetMapping("/status")
    public Page<statusResource> getAllstatus(Pageable pageable){
        Page<status> userPage = statusService.getAllstatus(pageable);
        List<statusResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"status"})
    @GetMapping("/status/{statusId}")
    public statusResource getstatusById(@PathVariable Integer statusId) {
        return convertToResource(statusService.getstatusById(statusId));
    }

    @Operation(tags={"status"})
    @PostMapping("/status")
    public statusResource createstatus(@Valid @RequestBody saveStatusResource resource) {
        status status = convertToEntity(resource);
        return convertToResource(statusService.createstatus(status));
    }

    @Operation(tags={"status"})
    @PutMapping("/status/{statusId}")
    public statusResource updatestatus(@PathVariable Integer statusId, @Valid @RequestBody saveStatusResource resource) {
        status status = convertToEntity(resource);
        return convertToResource(statusService.updatestatus(statusId, status));
    }

    @Operation(tags={"status"})
    @DeleteMapping("/status/{statusId}")
    public ResponseEntity<?> deleteStatus(
            @PathVariable Integer statusId) {
        return statusService.deletestatus(statusId);
    }


    private status convertToEntity(saveStatusResource resource) {
        return mapper.map(resource, status.class);
    }

    private statusResource convertToResource(status entity)
    {
        return mapper.map(entity, statusResource.class);
    }
}
