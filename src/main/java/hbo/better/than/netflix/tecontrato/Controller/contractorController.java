package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.contractor;
import hbo.better.than.netflix.tecontrato.domain.service.contractorService;
import hbo.better.than.netflix.tecontrato.resource.contractorResource;
import hbo.better.than.netflix.tecontrato.resource.saveContractorResource;
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
public class contractorController {

    @Autowired
    private contractorService contractorService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"contractors"})
    @GetMapping("/contractors")
    public Page<contractorResource> getAllContractors(Pageable pageable){
        Page<contractor> userPage = contractorService.getAllContractor(pageable);
        List<contractorResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"contractors"})
    @GetMapping("/contractors/{contractorId}")
    public contractorResource getContractorById(@PathVariable Integer contractorId) {
        return convertToResource(contractorService.getContractorById(contractorId));
    }

    @Operation(tags={"contractors"})
    @PostMapping("/contractors")
    public contractorResource createContractor(@Valid @RequestBody saveContractorResource resource) {
        contractor contractor = convertToEntity(resource);
        return convertToResource(contractorService.createContractor(contractor));
    }

    @Operation(tags={"contractors"})
    @PutMapping("/contractors/{contractorId}")
    public contractorResource updateContractor(@PathVariable Integer contractorId, @Valid @RequestBody saveContractorResource resource) {
        contractor contractor = convertToEntity(resource);
        return convertToResource(contractorService.updateContractor(contractorId, contractor));
    }

    @Operation(tags={"contractors"})
    @DeleteMapping("/contractors/{contractorId}")
    public ResponseEntity<?> deleteContractor(
            @PathVariable Integer contractorId) {
        return contractorService.deleteContractor(contractorId);
    }


    private contractor convertToEntity(saveContractorResource resource) {
        return mapper.map(resource, contractor.class);
    }

    private contractorResource convertToResource(contractor entity)
    {
        return mapper.map(entity, contractorResource.class);
    }
}
