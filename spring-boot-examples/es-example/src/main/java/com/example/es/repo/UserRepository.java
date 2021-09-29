package com.example.es.repo;

import com.example.es.dto.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author wuyang
 */
public interface UserRepository extends Repository<User, String> {
    List<User> findAll();
}
