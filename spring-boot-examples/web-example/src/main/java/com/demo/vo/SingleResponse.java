package com.demo.vo;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class SingleResponse<T> {

    private Boolean isSuccess;

    private T data;

    public static SingleResponse<?> success() {
        SingleResponse<?> singleResponse = new SingleResponse<>();
        singleResponse.setIsSuccess(true);
        return singleResponse;
    }

    public static <T> SingleResponse<T> success(T data) {
        SingleResponse<T> singleResponse = new SingleResponse<>();
        singleResponse.setIsSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }
}
