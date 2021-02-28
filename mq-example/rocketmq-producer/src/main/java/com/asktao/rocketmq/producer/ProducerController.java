package com.asktao.rocketmq.producer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author wcy
 */
@Slf4j
@RequestMapping
@RestController
public class ProducerController {

//    @Autowired
//    private MessageChannel output;
//
//    @GetMapping("/{msg}")
//    public String output(@PathVariable String msg) {
//        Map<String, Object> headers = new HashMap<>();
//        headers.put(MessageConst.PROPERTY_TAGS, "tag-a");
//        Message<String> message = MessageBuilder.createMessage(msg, new MessageHeaders(headers));
//        boolean send = output.send(message);
//        return "SEND result " + send + " : " + msg;
//    }

    @Autowired
    private DefaultMQProducer producer;

    @SneakyThrows
    @GetMapping("/sync/{msg}")
    public String sync(@PathVariable String msg) {
        Message message = new Message("test-consumer-topic", "tag-a", msg.getBytes(StandardCharsets.UTF_8));
        SendResult send = producer.send(message);
        log.info("sendResult = {}", send);
        return msg;
    }
}
