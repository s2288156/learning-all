package com.flink.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WuChunYang
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorReading {
    private String id;

    private Double temperature;

    private Long timestamp;
}
