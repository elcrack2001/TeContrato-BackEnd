package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.employees;
import hbo.better.than.netflix.tecontrato.domain.service.employeesService;
import hbo.better.than.netflix.tecontrato.resource.employeesResource;
import hbo.better.than.netflix.tecontrato.resource.saveEmployeesResource;
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
public class employeesController {
    @Autowired
    private employeesService employeesService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"employeess"})
    @GetMapping("/employeess")
    public Page<employeesResource> getAllemployeess(Pageable pageable){
        Page<employees> userPage = employeesService.getAllemployees(pageable);
        List<employeesResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"employeess"})
    @GetMapping("/employeess/{employeesId}")
    public employeesResource getemployeesById(@PathVariable Integer employeesId) {
        return convertToResource(employeesService.getemployeesById(employeesId));
    }

    @Operation(tags={"employeess"})
    @PostMapping("/job/{jobid}/employeess")
    public employeesResource createemployees(
            @PathVariable Integer jobid,
            @Valid @RequestBody saveEmployeesResource resource) {
        employees employees = convertToEntity(resource);
        return convertToResource(employeesService.createemployees(jobid, employees));
    }

    @Operation(tags={"employeess"})
    @PutMapping("/employeess/{employeesId}")
    public employeesResource updateemployees(@PathVariable Integer employeesId, @Valid @RequestBody saveEmployeesResource resource) {
        employees employees = convertToEntity(resource);
        return convertToResource(employeesService.updateemployees(employeesId, employees));
    }

    @Operation(tags={"employeess"})
    @DeleteMapping("/employeess/{employeesId}")
    public ResponseEntity<?> deleteEmployees(
            @PathVariable Integer employeesId) {
        return employeesService.deleteemployees(employeesId);
    }


    private employees convertToEntity(saveEmployeesResource resource) {
        return mapper.map(resource, employees.class);
    }

    private employeesResource convertToResource(employees entity)
    {
        return mapper.map(entity, employeesResource.class);
    }
}
