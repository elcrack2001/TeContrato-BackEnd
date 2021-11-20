package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.city;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface cityService {
    Page<city> getAllcity(Pageable pageable);
    city getcityById(Integer cityId);
    city createcity(city city);
    city updatecity(Integer cityId, city cityRequest);
    ResponseEntity<?> deletecity(Integer city);
}
