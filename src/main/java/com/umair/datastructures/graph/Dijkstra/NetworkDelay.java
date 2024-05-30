package com.umair.datastructures.graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelay {

    public static void main(String[] args) {

        int [][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n =4;
        int start = 2;

        System.out.println(new NetworkDelay().networkDelayTime(times,n,start));

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Edge> [] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: times){
            int s =edge[0]-1;
            int d =edge[1]-1;
            int t =edge[2];
            graph[s].add(new Edge(s,d,t));
        }

        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getTime));

        queue.add(new Pair(k-1,0));
        distance[k-1]=0;

        while(!queue.isEmpty()){
            Pair node = queue.poll();

            while(!visited[node.node]){
                visited[node.node]=true;
                for(int i=0;i<graph[node.node].size();i++){
                    Edge e = graph[node.node].get(i);
                    int des = e.dest;
                    if(distance[des]>distance[node.node]+e.weight){
                        distance[des] =distance[node.node]+e.weight;
                        queue.add(new Pair(des,distance[des]));
                    }

                }
            }
        }

        System.out.println(Arrays.toString(distance));
        int max =-1;

        for(int i=0;i<distance.length; i++){
            max = Math.max(max,distance[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;

    }

    static class Pair{

        int node;
        int time;

        public Pair(int node, int time){
            this.node=node;
            this.time=time;
        }

        public int getTime() {
            return time;
        }
    }

    static class Edge{

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


