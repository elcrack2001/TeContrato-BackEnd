package hbo.better.than.netflix.tecontrato.domain.repository;

import hbo.better.than.netflix.tecontrato.domain.model.budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface budgetRepository extends JpaRepository <budget, Integer> {
}
