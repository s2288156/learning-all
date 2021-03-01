package com.asktao.sample;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * @author wcy
 */
public class MqFactory {

    private static final String NAMESRV_ADDR = "node0.com:9876";

    public static DefaultMQProducer creatProducer() {
        DefaultMQProducer producer = new DefaultMQProducer("default_product_group");
        producer.setNamesrvAddr(NAMESRV_ADDR);
        return producer;
    }

    public static DefaultMQPushConsumer createPushConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("default_consumer_group");
        consumer.setNamesrvAddr(NAMESRV_ADDR);
        return consumer;
    }
}
