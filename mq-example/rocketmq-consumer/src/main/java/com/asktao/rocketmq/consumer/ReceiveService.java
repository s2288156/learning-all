package com.asktao.rocketmq.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class ReceiveService {

    @StreamListener("input1")
    public void receiveInput(String receiveMsg) {
        System.out.println(">>>>>>> " + receiveMsg);
    }
}
