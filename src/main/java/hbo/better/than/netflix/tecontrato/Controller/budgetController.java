package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.budget;
import hbo.better.than.netflix.tecontrato.domain.service.budgetService;
import hbo.better.than.netflix.tecontrato.resource.budgetResource;
import hbo.better.than.netflix.tecontrato.resource.saveBudgetResource;
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
public class budgetController {
    @Autowired
    private budgetService budgetService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"budgets"})
    @GetMapping("/budgets")
    public Page<budgetResource> getAllbudgets(Pageable pageable){
        Page<budget> userPage = budgetService.getAllbudget(pageable);
        List<budgetResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"budgets"})
    @GetMapping("/budgets/{budgetId}")
    public budgetResource getbudgetById(@PathVariable Integer budgetId) {
        return convertToResource(budgetService.getbudgetById(budgetId));
    }

    @Operation(tags={"budgets"})
    @PostMapping("/budgets")
    public budgetResource createbudget(@Valid @RequestBody saveBudgetResource resource) {
        budget budget = convertToEntity(resource);
        return convertToResource(budgetService.createbudget(budget));
    }

    @Operation(tags={"budgets"})
    @PutMapping("/budgets/{budgetId}")
    public budgetResource updatebudget(@PathVariable Integer budgetId, @Valid @RequestBody saveBudgetResource resource) {
        budget budget = convertToEntity(resource);
        return convertToResource(budgetService.updatebudget(budgetId, budget));
    }

    @Operation(tags={"budgets"})
    @DeleteMapping("/budgets/{budgetId}")
    public ResponseEntity<?> deleteBudget(
            @PathVariable Integer budgetId) {
        return budgetService.deletebudget(budgetId);
    }

    private budget convertToEntity(saveBudgetResource resource) {
        return mapper.map(resource, budget.class);
    }

    private budgetResource convertToResource(budget entity)
    {
        return mapper.map(entity, budgetResource.class);
    }
}
