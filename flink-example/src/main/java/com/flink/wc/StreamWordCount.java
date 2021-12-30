package com.flink.wc;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author WuChunYang
 */
public class StreamWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        String filePath = "/home/wuyang/IdeaProjects/learning-all/flink-example/src/main/resources/words.txt";
        DataStream<String> inputDataStream = env.readTextFile(filePath);
        DataStream<Tuple2<String, Integer>> resultDataStream = inputDataStream.flatMap(new WordCount.WordContMap())
                .keyBy(tuple -> tuple.f0)
                .sum(1);

        resultDataStream.print();

        resultDataStream.executeAndCollect();
    }
}
