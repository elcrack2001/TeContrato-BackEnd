package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.client;
import hbo.better.than.netflix.tecontrato.domain.service.clientService;
import hbo.better.than.netflix.tecontrato.resource.clientResource;
import hbo.better.than.netflix.tecontrato.resource.saveClientResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class clientController {

    @Autowired
    private clientService clientService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"clients"})
    @GetMapping("/clients")
    public Page<clientResource> getAllclients(Pageable pageable){
        Page<client> userPage = clientService.getAllclient(pageable);
        List<clientResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"clients"})
    @GetMapping("/clients/{clientId}")
    public clientResource getclientById(@PathVariable Integer clientId) {
        return convertToResource(clientService.getclientById(clientId));
    }

    @Operation(tags={"clients"})
    @PostMapping("/city/{cityid}/clients")
    public clientResource createclient(
            @PathVariable Integer cityid,
            @Valid @RequestBody saveClientResource resource) {
        client client = convertToEntity(resource);
        return convertToResource(clientService.createclient(cityid, client));
    }

    @Operation(tags={"clients"})
    @PutMapping("/clients/{clientId}")
    public clientResource updateclient(@PathVariable Integer clientId, @Valid @RequestBody saveClientResource resource) {
        client client = convertToEntity(resource);
        return convertToResource(clientService.updateclient(clientId, client));
    }

    @Operation(tags={"clients"})
    @DeleteMapping("/clients/{clientId}")
    public ResponseEntity<?> deleteClient(
            @PathVariable Integer clientId) {
        return clientService.deleteclient(clientId);
    }


    private client convertToEntity(saveClientResource resource) {
        return mapper.map(resource, client.class);
    }

    private clientResource convertToResource(client entity)
    {
        return mapper.map(entity, clientResource.class);
    }
}
