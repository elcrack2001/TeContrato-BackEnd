package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.client;
import hbo.better.than.netflix.tecontrato.domain.repository.cityRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.clientRepository;
import hbo.better.than.netflix.tecontrato.domain.service.clientService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class clientImpl implements clientService {
    @Autowired
    private clientRepository clientRepository;

    @Autowired
    private cityRepository cityRepository;

    @Override
    public Page<client> getAllclient(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public client getclientById(Integer clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("client","Id",clientId));
    }

    @Override
    public client createclient(Integer cityId, client client) {
        return cityRepository.findById(cityId).map(city -> {
            client.setCity(city);
            return clientRepository.save(client);
        }).orElseThrow(() -> new ResourceNotFoundException("city Id" + cityId));
    }

    @Override
    public client updateclient(Integer clientId, client clientRequest) {
        client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("client","Id",clientId));
        return clientRepository.findById(clientId).map(client1 -> {
            client1.setTbio(clientRequest.getTbio())
                    .setTadress(clientRequest.getTadress())
                    .setNuser(clientRequest.getNuser())
                    .setCpassword(clientRequest.getCpassword())
                    .setTmail(clientRequest.getTmail())
                    .setCdni(clientRequest.getCdni())
                    .setNname(clientRequest.getNname())
                    .setNlastname(clientRequest.getNlastname())
                    .setIsAdmin(clientRequest.getIsAdmin());
            return clientRepository.save(client1);
        }).orElseThrow(() -> new ResourceNotFoundException("client id" + clientId));
    }

    @Override
    public ResponseEntity<?> deleteclient(Integer client) {
        client client1 = clientRepository.findById(client)
                .orElseThrow(() -> new ResourceNotFoundException("client","Id",client));
        clientRepository.delete(client1);
        return ResponseEntity.ok().build();
    }
}
