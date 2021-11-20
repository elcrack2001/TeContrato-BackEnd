package hbo.better.than.netflix.tecontrato.service;

import hbo.better.than.netflix.tecontrato.domain.model.user;
import hbo.better.than.netflix.tecontrato.domain.repository.userRepository;
import hbo.better.than.netflix.tecontrato.domain.service.userService;
import hbo.better.than.netflix.tecontrato.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class userImpl implements userService {
    @Autowired
    private userRepository userRepository;

    @Override
    public Page<user> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public user getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
    }
}
