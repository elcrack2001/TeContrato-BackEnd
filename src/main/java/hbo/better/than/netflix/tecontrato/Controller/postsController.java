package hbo.better.than.netflix.tecontrato.Controller;

import hbo.better.than.netflix.tecontrato.domain.model.posts;
import hbo.better.than.netflix.tecontrato.domain.service.postsService;
import hbo.better.than.netflix.tecontrato.resource.postsResource;
import hbo.better.than.netflix.tecontrato.resource.savePostsResource;
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
public class postsController {
    @Autowired
    private postsService postsService;

    @Autowired
    private ModelMapper mapper;

    @Operation(tags={"posts"})
    @GetMapping("/posts")
    public Page<postsResource> getAllpostss(Pageable pageable){
        Page<posts> userPage = postsService.getAllposts(pageable);
        List<postsResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(tags={"posts"})
    @GetMapping("/posts/{postsId}")
    public postsResource getpostsById(@PathVariable Integer postsId) {
        return convertToResource(postsService.getpostsById(postsId));
    }

    @Operation(tags={"posts"})
    @PostMapping("/user/{userid}/posts")
    public postsResource createposts(
            @PathVariable Integer userid,
            @Valid @RequestBody savePostsResource resource) {
        posts posts = convertToEntity(resource);
        return convertToResource(postsService.createposts(userid, posts));
    }

    @Operation(tags={"posts"})
    @PutMapping("/posts/{postsId}")
    public postsResource updateposts(@PathVariable Integer postsId, @Valid @RequestBody savePostsResource resource) {
        posts posts = convertToEntity(resource);
        return convertToResource(postsService.updateposts(postsId, posts));
    }

    @Operation(tags={"posts"})
    @DeleteMapping("/posts/{postsId}")
    public ResponseEntity<?> deletePosts(
            @PathVariable Integer postsId) {
        return postsService.deleteposts(postsId);
    }


    private posts convertToEntity(savePostsResource resource) {
        return mapper.map(resource, posts.class);
    }

    private postsResource convertToResource(posts entity)
    {
        return mapper.map(entity, postsResource.class);
    }
}
