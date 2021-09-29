package com.demo.infuxdb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.query.FluxTable;

import java.util.List;

/**
 * @author wuyang
 */
public class InfluxTest {
    public static void main(String[] args) {
        String token = "8G-LNm8myKRX1OqpCrIJsdA4e5o5nAHuxuUD9ln4cfvhI2JWXYyYk8e4HmT-qhZ_kCuC65YIrSpVzI0dkmc-vQ==";
        String bucket = "demo";
        String org = "my";

        InfluxDBClient client = InfluxDBClientFactory.create("http://asktao.com:8086", token.toCharArray());

        String data = "mem,host=host1 used_percent=23.43234543";
        try (WriteApi writeApi = client.getWriteApi()) {
            writeApi.writeRecord(bucket, org, WritePrecision.NS, data);
        }

//        String query = String.format("from(bucket: \"%s\") |> range(start: -1h)", bucket);
//        List<FluxTable> tables = client.getQueryApi().query(query, org);
//        FluxTable fluxTable = tables.get(0);
//        fluxTable.getColumns().forEach(System.out::println);
    }
}
