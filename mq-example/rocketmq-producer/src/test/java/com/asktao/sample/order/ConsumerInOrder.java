package com.asktao.sample.order;

import com.asktao.sample.MqConst;
import com.asktao.sample.MqFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wcy
 */
@Slf4j
public class ConsumerInOrder {
    public static void main(String[] args) throws Exception{
        DefaultMQPushConsumer consumer = MqFactory.createPushConsumer();

        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        orderlyConsumer(consumer);

    }

    private static void orderlyConsumer(DefaultMQPushConsumer consumer) throws MQClientException {
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(MqConst.TOPIC_TEST, MqConst.TAG_A + " || " + MqConst.TAG_B + " || " + MqConst.TAG_C);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            Random random = new Random();
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                context.setAutoCommit(true);
                for (MessageExt msg : msgs) {
                    log.info("consumerThread={}, queueId={}, content:{}",
                            Thread.currentThread().getName(),
                            msg.getQueueId(),
                            new String(msg.getBody()));
                }
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        log.info("Consumer started.");
    }
}
