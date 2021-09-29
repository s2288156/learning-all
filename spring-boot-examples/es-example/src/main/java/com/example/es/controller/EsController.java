package com.example.es.controller;

import com.example.es.dto.Address;
import com.example.es.dto.User;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/rest/save")
    public String restSave(User user) {
        elasticsearchRestTemplate.save(user);
        return user.toString();
    }

    @PostMapping("/operation/save")
    public String operationSave(User user) {
        return user.toString();
    }
}
