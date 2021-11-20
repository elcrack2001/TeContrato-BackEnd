package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface clientService {
    Page<client> getAllclient(Pageable pageable);
    client getclientById(Integer clientId);
    client createclient(Integer cityId, client client);
    client updateclient(Integer clientId, client clientRequest);
    ResponseEntity<?> deleteclient(Integer client);
}
