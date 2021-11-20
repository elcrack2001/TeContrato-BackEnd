package hbo.better.than.netflix.tecontrato.domain.service;

import hbo.better.than.netflix.tecontrato.domain.model.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface userService {
    Page<user> getAllUsers(Pageable pageable);
    user getUserById(Integer userId);
}
