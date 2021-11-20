package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.user;
import hbo.better.than.netflix.tecontrato.domain.service.userService;
import hbo.better.than.netflix.tecontrato.resource.saveUserResource;
import hbo.better.than.netflix.tecontrato.resource.userResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class userController {
    @Autowired
    private userService userService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"users"})
    @GetMapping("/users")
    public Page<userResource> getAllUsers(Pageable pageable){
        Page<user> userPage = userService.getAllUsers(pageable);
        List<userResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"users"})
    @GetMapping("/users/{userId}")
    public userResource getUserById(@PathVariable Integer userId) {
        return convertToResource(userService.getUserById(userId));
    }

    private user convertToEntity(saveUserResource resource) {
        return mapper.map(resource, user.class);
    }

    private userResource convertToResource(user entity)
    {
        return mapper.map(entity, userResource.class);
    }

}
