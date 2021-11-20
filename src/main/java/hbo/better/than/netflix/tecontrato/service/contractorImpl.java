package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.contractor;
import hbo.better.than.netflix.tecontrato.domain.repository.contractorRepository;
import hbo.better.than.netflix.tecontrato.domain.service.contractorService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class contractorImpl implements contractorService {
    @Autowired
    private contractorRepository contractorRepository;

    @Override
    public Page<contractor> getAllContractor(Pageable pageable) {
        return contractorRepository.findAll(pageable);
    }

    @Override
    public contractor getContractorById(Integer contractorId) {
        return contractorRepository.findById(contractorId)
                .orElseThrow(() -> new ResourceNotFoundException("Contractor","Id",contractorId));
    }

    @Override
    public contractor createContractor(contractor contractor) {
        return contractorRepository.save(contractor);
    }

    @Override
    public contractor updateContractor(Integer contractorId, contractor contractorRequest) {
        contractor contractor = contractorRepository.findById(contractorId)
                .orElseThrow(() -> new ResourceNotFoundException("Contractor","Id",contractorId));
        return contractorRepository.findById(contractorId).map(contractor1 -> {
            contractor1.setTbio(contractorRequest.getTbio())
                    .setNeducation(contractorRequest.getNeducation())
                    .setNumphone(contractorRequest.getNumphone())
                    .setNuser(contractorRequest.getNuser())
                    .setCpassword(contractorRequest.getCpassword())
                    .setTmail(contractorRequest.getTmail())
                    .setCdni(contractorRequest.getCdni())
                    .setNname(contractorRequest.getNname())
                    .setNlastname(contractorRequest.getNlastname())
                    .setIsAdmin(contractorRequest.getIsAdmin());
            return contractorRepository.save(contractor1);
        }).orElseThrow(() -> new ResourceNotFoundException("contractor id" + contractorId));
    }

    @Override
    public ResponseEntity<?> deleteContractor(Integer contractor) {
        contractor contractor1 = contractorRepository.findById(contractor)
                .orElseThrow(() -> new ResourceNotFoundException("Contractor","Id",contractor));
        contractorRepository.delete(contractor1);
        return ResponseEntity.ok().build();
    }
}
