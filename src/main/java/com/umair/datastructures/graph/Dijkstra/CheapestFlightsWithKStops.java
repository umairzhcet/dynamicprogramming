package com.umair.datastructures.graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStops {

    public static void main(String[] args) {

        //int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int n =5;
        int src = 0;
        int dest = 2;
        int k = 2;

        CheapestFlightsWithKStops main = new CheapestFlightsWithKStops();
        System.out.println(main.findCheapestPrice(n,flights,src,dest,k));

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: flights){
            int s = edge[0];
            int d = edge[1];
            int p = edge[2];

            graph[s].add(new Edge(s,d,p));
        }

        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<Tuple> queue = new PriorityQueue<>();

        queue.add(new Tuple(src,0,0));
        distance[src] = 0;

        while(!queue.isEmpty()){
            Tuple curr=queue.remove();
            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.price;
                if ( curr.price + wt < distance[v] && curr.stops <= k) {
                    distance[v] = curr.price + wt;
                    queue.add(new Tuple(v, distance[v], curr.stops + 1));
                }
            }

        }
        System.out.println(Arrays.toString(distance));
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }


    static class Edge{

        int src;
        int dest;
        int price;

        public Edge(int s, int d, int p){
            this.src = s;
            this.dest = d;
            this.price = p;
        }
    }

    static class Tuple implements Comparable<Tuple>{

        int node;
        int price;

        int stops;

        public Tuple(int node, int price, int stops){
            this.node=node;
            this.price=price;
            this.stops=stops;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Tuple o) {
            if(this.stops==o.stops){
                return this.price-o.price;
            }
            return this.stops-o.stops;
        }
    }

}
