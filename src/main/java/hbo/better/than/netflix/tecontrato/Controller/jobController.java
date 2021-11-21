package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.job;
import hbo.better.than.netflix.tecontrato.domain.service.jobService;
import hbo.better.than.netflix.tecontrato.resource.jobResource;
import hbo.better.than.netflix.tecontrato.resource.saveJobResource;
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
public class jobController {
    @Autowired
    private jobService jobService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"jobs"})
    @GetMapping("/jobs")
    public Page<jobResource> getAlljobs(Pageable pageable){
        Page<job> userPage = jobService.getAlljob(pageable);
        List<jobResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"jobs"})
    @GetMapping("/jobs/{jobId}")
    public jobResource getjobById(@PathVariable Integer jobId) {
        return convertToResource(jobService.getjobById(jobId));
    }

    @Operation(tags={"jobs"})
    @PostMapping("/jobs")
    public jobResource createjob(@Valid @RequestBody saveJobResource resource) {
        job job = convertToEntity(resource);
        return convertToResource(jobService.createjob(job));
    }

    @Operation(tags={"jobs"})
    @PutMapping("/jobs/{jobId}")
    public jobResource updatejob(@PathVariable Integer jobId, @Valid @RequestBody saveJobResource resource) {
        job job = convertToEntity(resource);
        return convertToResource(jobService.updatejob(jobId, job));
    }

    @Operation(tags={"jobs"})
    @DeleteMapping("/jobs/{jobId}")
    public ResponseEntity<?> deleteJob(
            @PathVariable Integer jobId) {
        return jobService.deletejob(jobId);
    }


    private job convertToEntity(saveJobResource resource) {
        return mapper.map(resource, job.class);
    }

    private jobResource convertToResource(job entity)
    {
        return mapper.map(entity, jobResource.class);
    }
}
