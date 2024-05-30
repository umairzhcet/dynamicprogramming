package com.umair.datastructures.graph.Dijkstra;

import java.util.*;

public class MaximumProbabilityPath {

    public static void main(String[] args) {

        int [][] edges = {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double[] succProb =  {0.37,0.17,0.93,0.23,0.39,0.04};
        int n =5;
        int start = 3;
        int end = 4;

        System.out.println(new MaximumProbabilityPath().maxProbability(n,edges,succProb,start,end));

    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        double[] distance = new double[n];
        for(int i = 0;i<n;i++){
            distance[i]=0;
        }

        for(int i =0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0;i<edges.length;i++){
            int[] edge =edges[i];
            int from = edge[0];
            int to = edge[1];
            double prob =succProb[i];
            graph[from].add(new Edge(from,to,prob));
            graph[to].add(new Edge(to,from,prob));
        }

        double[] maxprob = new double[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getProb).reversed());

        queue.add(new Pair(start_node,1));
        distance[start_node]=1;

        while(!queue.isEmpty()){
            Pair node = queue.poll();
            if(!visited[node.node]) {
                visited[node.node] = true;
                for (int i = 0; i<graph[node.node].size(); i++) {
                    Edge edge = graph[node.node].get(i);
                    if (edge.weight * distance[edge.src] >distance[edge.dest] ) {
                        distance[edge.dest] = edge.weight * distance[edge.src];
                        queue.add(new Pair(edge.dest, distance[edge.dest]));
                    }

                }
            }
        }

        System.out.println(Arrays.toString(distance));


        return distance[end_node];

    }

    static class Pair{

        int node;
        double prob;

        public Pair(int node, double prob){
            this.node=node;
            this.prob=prob;
        }

        public double getProb() {
            return prob;
        }
    }

    static class Edge{

        int src;
        int dest;

        double weight;

        public Edge(int s, int d, double w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

}


