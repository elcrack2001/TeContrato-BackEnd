package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.city;
import hbo.better.than.netflix.tecontrato.domain.service.cityService;
import hbo.better.than.netflix.tecontrato.resource.cityResource;
import hbo.better.than.netflix.tecontrato.resource.saveCityResource;
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
public class cityController {

    @Autowired
    private cityService cityService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"citys"})
    @GetMapping("/citys")
    public Page<cityResource> getAllcitys(Pageable pageable){
        Page<city> userPage = cityService.getAllcity(pageable);
        List<cityResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"citys"})
    @GetMapping("/citys/{cityId}")
    public cityResource getcityById(@PathVariable Integer cityId) {
        return convertToResource(cityService.getcityById(cityId));
    }

    @Operation(tags={"citys"})
    @PostMapping("/citys")
    public cityResource createcity(@Valid @RequestBody saveCityResource resource) {
        city city = convertToEntity(resource);
        return convertToResource(cityService.createcity(city));
    }

    @Operation(tags={"citys"})
    @PutMapping("/citys/{cityId}")
    public cityResource updatecity(@PathVariable Integer cityId, @Valid @RequestBody saveCityResource resource) {
        city city = convertToEntity(resource);
        return convertToResource(cityService.updatecity(cityId, city));
    }

    @Operation(tags={"citys"})
    @DeleteMapping("/citys/{cityId}")
    public ResponseEntity<?> deleteCity(
            @PathVariable Integer cityId) {
        return cityService.deletecity(cityId);
    }

    private city convertToEntity(saveCityResource resource) {
        return mapper.map(resource, city.class);
    }

    private cityResource convertToResource(city entity)
    {
        return mapper.map(entity, cityResource.class);
    }
}
