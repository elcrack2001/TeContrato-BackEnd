package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface jobService {
    Page<job> getAlljob(Pageable pageable);
    job getjobById(Integer jobId);
    job createjob(job job);
    job updatejob(Integer jobId, job jobRequest);
    ResponseEntity<?> deletejob(Integer job);
}
