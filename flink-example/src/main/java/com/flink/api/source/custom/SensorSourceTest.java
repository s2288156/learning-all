package com.flink.api.source.custom;

import com.flink.api.beans.SensorReading;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author WuChunYang
 */
public class SensorSourceTest implements SourceFunction<SensorReading> {
    private boolean running = true;

    @Override
    public void run(SourceContext<SensorReading> ctx) throws Exception {
        while (running) {
            Random random = new Random();
            Map<String, Double> initSensorMap = new HashMap<>(16);
            for (int i = 0; i < 3; i++) {
                initSensorMap.put("sid_" + i, random.nextGaussian() + 30);
            }

            while (running) {
                initSensorMap.forEach((k, v) -> {
                    ctx.collect(new SensorReading(k, v + random.nextGaussian(), System.currentTimeMillis()));
                });
                Thread.sleep(2000);
            }
        }
    }

    @Override
    public void cancel() {
        this.running = false;
    }
}
