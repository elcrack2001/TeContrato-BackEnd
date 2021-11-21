package hbo.better.than.netflix.tecontrato.domain.repository;

import hbo.better.than.netflix.tecontrato.domain.model.taksProjectControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface taksProjectControlRepository extends JpaRepository<taksProjectControl, Integer> {
    Page<taksProjectControl> findByProjectControlId(Integer projectControlId, Pageable pageable);
    Page<taksProjectControl> findByEmployeesId(Integer employeesId, Pageable pageable);
    Page<taksProjectControl> findByTaskId(Integer taskId, Pageable pageable);
    public Optional<taksProjectControl> findByIdAndProjectControlId (Integer id, Integer projectControlId);
    public Optional<taksProjectControl> findByIdAndEmployeesId (Integer id, Integer employeesId);
    public Optional<taksProjectControl> findByIdAndTaskId (Integer id, Integer taskId);
}
