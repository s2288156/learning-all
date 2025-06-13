package com.demo.vo;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class SingleResponse {

    private Boolean isSuccess;

    public static SingleResponse success() {
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.setIsSuccess(true);
        return singleResponse;
    }
}
