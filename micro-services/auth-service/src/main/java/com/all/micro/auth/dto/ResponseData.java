package com.all.micro.auth.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Wu.Chunyang
 */
@Data
public class ResponseData<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseData<T> success(T data){
        ResponseData<T> responseData = new ResponseData<T>();
        responseData.setCode(HttpStatus.OK.value());
        responseData.setMessage("success");
        responseData.setData(data);
        return responseData;
    }

    public static <T> ResponseData<T> unauthorized(){
        ResponseData<T> responseData = new ResponseData<T>();
        responseData.setCode(HttpStatus.UNAUTHORIZED.value());
        responseData.setMessage("success");
        responseData.setData(null);
        return responseData;
    }
}
