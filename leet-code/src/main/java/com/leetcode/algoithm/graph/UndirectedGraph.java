package com.leetcode.algoithm.graph;

import java.util.LinkedList;

/**
 * 无向图
 *
 * @author wcy
 */
public class UndirectedGraph implements Graph {
    /**
     * 定点数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public UndirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
}
