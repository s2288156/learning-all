package com.flink.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * 单词批处理统计
 *
 * @author WuChunYang
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        String filePath = "/home/wuyang/IdeaProjects/learning-all/flink-example/src/main/resources/words.txt";
        DataSet<String> inputDataSet = env.readTextFile(filePath);
        DataSet<Tuple2<String, Integer>> resultSet = inputDataSet.flatMap(new WordContMap())
                .groupBy(0)
                .sum(1);
        resultSet.print();
    }

    public static class WordContMap implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
            String[] words = s.split(" ");
            for (String word : words) {
                collector.collect(new Tuple2<>(word, 1));
            }
        }
    }

}
