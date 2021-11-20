package hbo.better.than.netflix.tecontrato.domain.repository;

import hbo.better.than.netflix.tecontrato.domain.model.projectControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectControlRepository extends JpaRepository<projectControl, Integer> {
}
