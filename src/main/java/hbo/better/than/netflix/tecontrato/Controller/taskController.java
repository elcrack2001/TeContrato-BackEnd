package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.task;
import hbo.better.than.netflix.tecontrato.domain.service.taskService;
import hbo.better.than.netflix.tecontrato.resource.taskResource;
import hbo.better.than.netflix.tecontrato.resource.saveTaskResource;
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
public class taskController {
    @Autowired
    private taskService taskService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"tasks"})
    @GetMapping("/tasks")
    public Page<taskResource> getAlltasks(Pageable pageable){
        Page<task> userPage = taskService.getAlltask(pageable);
        List<taskResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"tasks"})
    @GetMapping("/tasks/{taskId}")
    public taskResource gettaskById(@PathVariable Integer taskId) {
        return convertToResource(taskService.gettaskById(taskId));
    }

    @Operation(tags={"tasks"})
    @PostMapping("/tasks")
    public taskResource createtask(@Valid @RequestBody saveTaskResource resource) {
        task task = convertToEntity(resource);
        return convertToResource(taskService.createtask(task));
    }

    @Operation(tags={"tasks"})
    @PutMapping("/tasks/{taskId}")
    public taskResource updatetask(@PathVariable Integer taskId, @Valid @RequestBody saveTaskResource resource) {
        task task = convertToEntity(resource);
        return convertToResource(taskService.updatetask(taskId, task));
    }

    @Operation(tags={"tasks"})
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<?> deleteTask(
            @PathVariable Integer taskId) {
        return taskService.deletetask(taskId);
    }

    private task convertToEntity(saveTaskResource resource) {
        return mapper.map(resource, task.class);
    }

    private taskResource convertToResource(task entity)
    {
        return mapper.map(entity, taskResource.class);
    }
}
