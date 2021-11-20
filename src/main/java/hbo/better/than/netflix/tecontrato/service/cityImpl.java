package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.city;
import hbo.better.than.netflix.tecontrato.domain.repository.cityRepository;
import hbo.better.than.netflix.tecontrato.domain.service.cityService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class cityImpl implements cityService {
    @Autowired
    private cityRepository cityRepository;
    
    @Override
    public Page<city> getAllcity(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public city getcityById(Integer cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("city","Id",cityId));
    }

    @Override
    public city createcity(city city) {
        return cityRepository.save(city);
    }

    @Override
    public city updatecity(Integer cityId, city cityRequest) {
        city city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("city","Id",cityId));
        return cityRepository.findById(cityId).map(city1 -> {
            city1.setNcity(cityRequest.getNcity());
            return  cityRepository.save(city1);
        }).orElseThrow(() -> new ResourceNotFoundException("city id" + cityId));
    }

    @Override
    public ResponseEntity<?> deletecity(Integer city) {
        city city1 = cityRepository.findById(city)
                .orElseThrow(() -> new ResourceNotFoundException("city","Id",city));
        cityRepository.delete(city1);
        return ResponseEntity.ok().build();
    }
}
