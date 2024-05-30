package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinCostToConnectAllPoints main = new MinCostToConnectAllPoints();
        System.out.println(main.minCostConnectPoints(points));
    }
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int x2 = points[i][1];

                int x3 = points[j][0];
                int x4 = points[j][1];

                int dis = Math.abs(x1-x3)+Math.abs(x2-x4);

                graph[i].add(new Edge(i,j,dis));
                graph[j].add(new Edge(j,i,dis));

            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getCost));

        pq.add(new Pair(0,0));
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int noofEdges =0;
        while(!pq.isEmpty() && noofEdges!=n){
            Pair current = pq.poll();
            if(!visited[current.node]){
                visited[current.node]=true;
                totalCost+=current.cost;
                noofEdges++;
                for(int i=0;i<graph[current.node].size();i++){
                    Edge e = graph[current.node].get(i);

                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest,e.weight));
                    }
                }
            }
        }

        return  totalCost;
    }

    static class Pair {

        int node;
        int cost;

        public Pair(int s, int cost){
            this.node = s;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }

    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }


}
