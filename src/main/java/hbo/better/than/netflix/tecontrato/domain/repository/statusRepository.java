package hbo.better.than.netflix.tecontrato.domain.repository;

import hbo.better.than.netflix.tecontrato.domain.model.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statusRepository extends JpaRepository<status, Integer> {
}
