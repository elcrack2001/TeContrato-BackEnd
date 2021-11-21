package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.task;
import hbo.better.than.netflix.tecontrato.domain.repository.taskRepository;
import hbo.better.than.netflix.tecontrato.domain.service.taskService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class taskImpl implements taskService {

    @Autowired
    private taskRepository taskRepository;

    @Override
    public Page<task> getAlltask(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public task gettaskById(Integer taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task","Id",taskId));
    }

    @Override
    public task createtask(task task) {
        return taskRepository.save(task);
    }

    @Override
    public task updatetask(Integer taskId, task taskRequest) {
        task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task","Id",taskId));
        return taskRepository.findById(taskId).map(task1 -> {
            task1.setNtask(taskRequest.getNtask());
            return  taskRepository.save(task1);
        }).orElseThrow(() -> new ResourceNotFoundException("task id" + taskId));
    }

    @Override
    public ResponseEntity<?> deletetask(Integer task) {
        task task1 = taskRepository.findById(task)
                .orElseThrow(() -> new ResourceNotFoundException("task","Id",task));
        taskRepository.delete(task1);
        return ResponseEntity.ok().build();
    }
}
