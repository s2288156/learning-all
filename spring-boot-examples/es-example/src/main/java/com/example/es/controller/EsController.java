package com.example.es.controller;

import com.example.es.dto.Address;
import com.example.es.dto.User;
import com.example.es.repo.UserRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 */
@RequestMapping("/es")
@RestController
public class EsController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/rest/save")
    public String restSave(User user) {
        elasticsearchRestTemplate.save(user);
        return user.toString();
    }

    @PostMapping("/operation/save")
    public String operationSave(User user) {
        elasticsearchOperations.save(user);
        return user.toString();
    }

    @DeleteMapping("/rest/one")
    public String deleteOne(String id) {
        String delete = elasticsearchRestTemplate.delete(id, User.class);
        return delete;
    }

    @GetMapping("/all/user")
    public List<User> allUser() {
        List<User> all = userRepository.findAll();
        return all;
    }
}
