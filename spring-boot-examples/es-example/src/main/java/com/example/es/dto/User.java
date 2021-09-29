package com.example.es.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author wuyang
 */
@Document(indexName = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8584619697091580812L;

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "age")
    private int age;

    @Field(name = "desc")
    private String desc;

    @Field(name = "school")
    private String school;

    @Field(name = "address")
    private Address address;

    public User() {
        initAddress();
    }

    private void initAddress() {
        Address address = new Address();
        address.setLocation("北京");
        address.setZipCode("100000");
        this.address = address;
    }
}
