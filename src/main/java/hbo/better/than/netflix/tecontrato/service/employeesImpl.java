package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.employees;
import hbo.better.than.netflix.tecontrato.domain.repository.employeesRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.jobRepository;
import hbo.better.than.netflix.tecontrato.domain.service.employeesService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class employeesImpl implements employeesService {
    @Autowired
    private employeesRepository employeesRepository;

    @Autowired
    private jobRepository jobRepository;
    
    @Override
    public Page<employees> getAllemployees(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    @Override
    public employees getemployeesById(Integer employeesId) {
        return employeesRepository.findById(employeesId)
                .orElseThrow(() -> new ResourceNotFoundException("employees","Id",employeesId));
    }

    @Override
    public employees createemployees(Integer jobId, employees employees) {
        return jobRepository.findById(jobId).map(job -> {
            employees.setJob(job);
            return employeesRepository.save(employees);
        }).orElseThrow(() -> new ResourceNotFoundException("job Id" + jobId));
    }

    @Override
    public employees updateemployees(Integer employeesId, employees employeesRequest) {
        employees employees = employeesRepository.findById(employeesId)
                .orElseThrow(() -> new ResourceNotFoundException("employees","Id",employeesId));
        return employeesRepository.findById(employeesId).map(employees1 -> {
            employees1.setNemployee(employeesRequest.getNemployee())
                    .setTposition(employeesRequest.getTposition())
                    .setMpayment(employeesRequest.getMpayment())
                    .setTworks(employeesRequest.getTworks());
            return employeesRepository.save(employees1);
        }).orElseThrow(() -> new ResourceNotFoundException("employees id" + employeesId));
    }

    @Override
    public ResponseEntity<?> deleteemployees(Integer employees) {
        employees employees1 = employeesRepository.findById(employees)
                .orElseThrow(() -> new ResourceNotFoundException("employees","Id",employees));
        employeesRepository.delete(employees1);
        return ResponseEntity.ok().build();
    }
}
