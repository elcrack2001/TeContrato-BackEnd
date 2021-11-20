package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.job;
import hbo.better.than.netflix.tecontrato.domain.repository.jobRepository;
import hbo.better.than.netflix.tecontrato.domain.service.jobService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class jobImpl implements jobService {
    @Autowired
    private jobRepository jobRepository;
    
    @Override
    public Page<job> getAlljob(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public job getjobById(Integer jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("job","Id",jobId));
    }

    @Override
    public job createjob(job job) {
        return jobRepository.save(job);
    }

    @Override
    public job updatejob(Integer jobId, job jobRequest) {
        job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("job","Id",jobId));
        return jobRepository.findById(jobId).map(job1 -> {
            job1.setNjob(jobRequest.getNjob())
                    .setTdescripcion(jobRequest.getTdescripcion());
            return  jobRepository.save(job1);
        }).orElseThrow(() -> new ResourceNotFoundException("job id" + jobId));
    }

    @Override
    public ResponseEntity<?> deletejob(Integer job) {
        job job1 = jobRepository.findById(job)
                .orElseThrow(() -> new ResourceNotFoundException("job","Id",job));
        jobRepository.delete(job1);
        return ResponseEntity.ok().build();
    }
}
