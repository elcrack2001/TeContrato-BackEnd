package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.budget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface budgetService {
    Page<budget> getAllbudget(Pageable pageable);
    budget getbudgetById(Integer budgetId);
    budget createbudget(budget budget);
    budget updatebudget(Integer budgetId, budget budgetRequest);
    ResponseEntity<?> deletebudget(Integer budget);
}
