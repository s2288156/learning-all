package com.asktao.rocketmq.producer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author wcy
 */
@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class ProducerApplication {
}
