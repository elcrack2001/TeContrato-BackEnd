package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.budget;
import hbo.better.than.netflix.tecontrato.domain.repository.budgetRepository;
import hbo.better.than.netflix.tecontrato.domain.service.budgetService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class budgetImpl implements budgetService {

    @Autowired
    private budgetRepository budgetRepository;

    @Override
    public Page<budget> getAllbudget(Pageable pageable) {
        return budgetRepository.findAll(pageable);
    }

    @Override
    public budget getbudgetById(Integer budgetId) {
        return budgetRepository.findById(budgetId)
                .orElseThrow(() -> new ResourceNotFoundException("budget","Id",budgetId));
    }

    @Override
    public budget createbudget(budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public budget updatebudget(Integer budgetId, budget budgetRequest) {
        budget budget = budgetRepository.findById(budgetId)
                .orElseThrow(() -> new ResourceNotFoundException("budget","Id",budgetId));
        return budgetRepository.findById(budgetId).map(budget1 -> {
            budget1.setTdescription(budgetRequest.getTdescription())
                    .setMmonto(budgetRequest.getMmonto())
                    .setDfecha(budgetRequest.getDfecha());
            return  budgetRepository.save(budget1);
        }).orElseThrow(() -> new ResourceNotFoundException("budget id" + budgetId));
    }

    @Override
    public ResponseEntity<?> deletebudget(Integer budget) {
        budget budget1 = budgetRepository.findById(budget)
                .orElseThrow(() -> new ResourceNotFoundException("budget","Id",budget));
        budgetRepository.delete(budget1);
        return ResponseEntity.ok().build();
    }
}
