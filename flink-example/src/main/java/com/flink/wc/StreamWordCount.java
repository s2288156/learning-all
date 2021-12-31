package com.flink.wc;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * com.flink.wc.StreamWordCount
 * --host localhost --port 7777
 *
 * @author WuChunYang
 */
public class StreamWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 读取txt文件
        // String filePath = "/home/wuyang/IdeaProjects/learning-all/flink-example/src/main/resources/words.txt";
        // DataStream<String> inputDataStream = env.readTextFile(filePath);

        // 通过linux工具: nc -lk 7777 通过socket服务输入, Java Parameter: --host localhost --port 7777
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("host");
        int port = parameterTool.getInt("port");
        DataStreamSource<String> inputDataStream = env.socketTextStream(host, port);
        DataStream<Tuple2<String, Integer>> resultDataStream = inputDataStream.flatMap(new WordCount.WordContMap())
                .keyBy(tuple -> tuple.f0)
                .sum(1);

        resultDataStream.print();

        env.execute();
    }
}
