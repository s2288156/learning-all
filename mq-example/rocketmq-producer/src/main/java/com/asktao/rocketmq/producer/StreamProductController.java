package com.asktao.rocketmq.producer;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wcy
 */
@RequestMapping("/stream")
@RestController
public class StreamProductController {
    @Autowired
    private MessageChannel output;

    @GetMapping("/{msg}")
    public String output(@PathVariable String msg) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "tag-aa");
        Message<String> message = MessageBuilder.createMessage(msg, new MessageHeaders(headers));
        boolean send = output.send(message);
        return "SEND result " + send + " : " + msg;
    }
}
