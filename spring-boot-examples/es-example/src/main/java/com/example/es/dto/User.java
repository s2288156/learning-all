package com.example.es.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author wuyang
 */
@Document(indexName = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8584619697091580812L;

    @Id
    @Field(docValues = false)
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "age", type = FieldType.Text)
    private Integer age;

    @Field(name = "desc")
    private String desc;

    private String school;

    @Field(type = FieldType.Date)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

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
