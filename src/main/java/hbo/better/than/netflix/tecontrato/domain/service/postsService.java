package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface postsService {
    Page<posts> getAllposts(Pageable pageable);
    posts getpostsById(Integer postsId);
    posts createposts(Integer userid, posts posts);
    posts updateposts(Integer postsId, posts postsRequest);
    ResponseEntity<?> deleteposts(Integer posts);
}
