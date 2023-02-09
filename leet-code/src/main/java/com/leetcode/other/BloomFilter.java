package com.leetcode.other;

import java.util.BitSet;

/**
 * @author wcy
 */
public class BloomFilter {
    private static final int DEFAULT_SIZE = 2 << 24;

    private static final int[] SEEDS = new int[]{13, 22, 737, 89, 29, 65};

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public BloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(Object value) {
        boolean ref = true;
        for (SimpleHash f : func) {
            ref = ref && bits.get(f.hash(value));
        }
        return ref;
    }

    public static class SimpleHash {
        private int cap;

        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }
}
