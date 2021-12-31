package com.flink.api.source;

import com.flink.api.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.List;

/**
 * @author WuChunYang
 */
public class SourceTestCollection {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<SensorReading> inputStream = env.fromCollection(List.of(
                new SensorReading("1", 30.1, 1640924626183L),
                new SensorReading("2", 32.3, 1640924626193L),
                new SensorReading("3", 34.2, 1640924626203L),
                new SensorReading("4", 27.3, 1640924626283L)
        ));

        inputStream.print("sensor-data");

        env.execute();
    }
}
