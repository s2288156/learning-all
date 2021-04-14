package com.learning.algoithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分布式缓存
 *
 * @author wcy
 */
public class DistributedCatch {

    public static void main(String[] args) {
        DistributedCatch distributedCatch1 = new DistributedCatch(5);
        DistributedCatch distributedCatch2 = new DistributedCatch(7);

        int[] hashCodes = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        distributedCatch1.handleCatch(hashCodes);
        distributedCatch2.handleCatch(hashCodes);
    }

    private int machineCount;

    private Map<Integer, List<Integer>> catchData;

    public DistributedCatch(int machineCount) {
        this.machineCount = machineCount;
    }

    public void handleCatch(int[] hashCodes) {
        catchData = new HashMap<>(64);
        for (int hashCode : hashCodes) {
            int key = hashCode % machineCount;
            List<Integer> value = catchData.get(key);
            if (value == null) {
                value = new ArrayList<>();
            }
            value.add(hashCode);
            catchData.put(key, value);
        }
        System.out.println(catchData);
    }

}
