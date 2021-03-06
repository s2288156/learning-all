package com.asktao.sample;

import com.asktao.rocketmq.MqConst;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author wcy
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = MqFactory.creatProducer();
        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.43.129:9876");
        // 启动Producer实例
        producer.start();
        for (int i = 0; i < 3; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message(MqConst.TOPIC_TEST /* Topic */,
                    MqConst.TAG_N /* Tag */,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // 发送消息到一个Broker
            SendResult sendResult = producer.send(msg);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
