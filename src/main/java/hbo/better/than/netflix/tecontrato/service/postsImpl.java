package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.posts;
import hbo.better.than.netflix.tecontrato.domain.repository.postsRepository;
import hbo.better.than.netflix.tecontrato.domain.repository.userRepository;
import hbo.better.than.netflix.tecontrato.domain.service.postsService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class postsImpl implements postsService {
    @Autowired
    private postsRepository postsRepository;

    @Autowired
    private userRepository userRepository;

    @Override
    public Page<posts> getAllposts(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    @Override
    public posts getpostsById(Integer postsId) {
        return postsRepository.findById(postsId)
                .orElseThrow(() -> new ResourceNotFoundException("posts","Id",postsId));
    }

    @Override
    public posts createposts(Integer userid, posts posts) {
        return userRepository.findById(userid).map(user -> {
            posts.setUser(user);
            return postsRepository.save(posts);
        }).orElseThrow(() -> new ResourceNotFoundException("user Id" + userid));
    }

    @Override
    public posts updateposts(Integer postsId, posts postsRequest) {
        posts posts = postsRepository.findById(postsId)
                .orElseThrow(() -> new ResourceNotFoundException("posts","Id",postsId));
        return postsRepository.findById(postsId).map(posts1 -> {
            posts1.setNtitle(postsRequest.getNtitle())
                    .setTbody(postsRequest.getTbody())
                    .setCreate_at(postsRequest.getCreate_at())
                    .setMbuget(postsRequest.getMbuget())
                    .setViews(postsRequest.getViews())
                    .setPic(postsRequest.getPic());
            return postsRepository.save(posts1);
        }).orElseThrow(() -> new ResourceNotFoundException("posts id" + postsId));
    }

    @Override
    public ResponseEntity<?> deleteposts(Integer posts) {
        posts posts1 = postsRepository.findById(posts)
                .orElseThrow(() -> new ResourceNotFoundException("posts","Id",posts));
        postsRepository.delete(posts1);
        return ResponseEntity.ok().build();
    }
}
