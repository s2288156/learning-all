package com.demo.controller;

import com.demo.service.IServiceA;
import com.demo.service.IServiceB;
import com.demo.vo.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyang
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private IServiceA serviceA;

    @Autowired
    private IServiceB serviceB;


    @GetMapping("/test/done")
    public Map<String, Object> done() throws InterruptedException {
        Integer id = RandomUtils.nextInt(0, 100);
        log.info("test done request >>>>> id: {}", id);
        Map<String, Object> result = new HashMap<>();
        // result.put("ack", "OK");
        TimeUnit.SECONDS.sleep(8);
        log.info("test done response >>>>> id: {}", id);
        return result;
    }

    @PostMapping("/test/done/failure")
    public ResponseEntity<Map<String, Object>> doneFail(@RequestBody Map<String, String> request) {
        log.info("### {}", request);
        Map<String, Object> result = new HashMap<>();
        // result.put("ack", "NG");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test/state")
    public Map<String, Object> state(@RequestParam Map<String, String> request) {
        Map<String, Object> result = new HashMap<>();
        result.put("ack", "OK");
        return result;
    }

    @GetMapping("/request")
    public SingleResponse<?> req() {
        log.info("request start");
        return SingleResponse.success();
    }

    @GetMapping("/request/delay")
    public SingleResponse reqDelay() {
        log.info("request delay start");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("request delay end");
        return SingleResponse.success();
    }

    @GetMapping("/service/a")
    public String serviceA() {
        log.info("serviceA");
        return serviceA.saySelf();
    }

    @GetMapping("/service/b")
    public String serviceB() {
        return serviceB.saySelf();
    }
}
