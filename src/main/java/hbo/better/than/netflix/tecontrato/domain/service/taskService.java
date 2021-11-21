package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface taskService {
    Page<task> getAlltask(Pageable pageable);
    task gettaskById(Integer taskId);
    task createtask(task task);
    task updatetask(Integer taskId, task taskRequest);
    ResponseEntity<?> deletetask(Integer task);
}
