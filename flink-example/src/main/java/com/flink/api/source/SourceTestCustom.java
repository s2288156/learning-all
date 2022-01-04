package com.flink.api.source;

import com.flink.api.beans.SensorReading;
import com.flink.api.source.custom.SensorSourceTest;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author WuChunYang
 */
public class SourceTestCustom {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<SensorReading> inputStream = env.addSource(new SensorSourceTest());
        SingleOutputStreamOperator<SensorReading> outputSteam = inputStream.keyBy(SensorReading::getId)
                .max("temperature");

        outputSteam.print();

        env.execute();
    }

}
