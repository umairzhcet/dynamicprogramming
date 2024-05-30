package com.umair.datastructures.graph.Prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToConnectAllPointsPrims {

    PriorityQueue<Edge> pq;
    ArrayList<Edge> graph[];
    boolean[] visited;

    public static void main(String[] args) {

        int[][] points={{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinimumCostToConnectAllPointsPrims main=new MinimumCostToConnectAllPointsPrims();
        System.out.println(main.minCostConnectPoints(points));
    }
    public int minCostConnectPoints(int[][] points) {

        int n=points.length;

        graph= new ArrayList[n];

        pq=new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));


        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        //create graph

        for(int i=0;i<n;i++){
            int xi=points[i][0];
            int yi=points[i][1];

            for(int j=i+1;j<n;j++){
                int xj=points[j][0];
                int yj=points[j][1];

                int cost=Math.abs(xi-xj)+Math.abs(yi-yj);
                graph[i].add(new Edge(i,j,cost));
                graph[j].add(new Edge(j,i,cost));
            }
        }

        int minCost=0;
        int noofEdges=0;
        visited=new boolean[n];

        addEdges(0);

        while(!pq.isEmpty() && noofEdges!=n-1){
            Edge e=pq.poll();
            if(visited[e.to]) continue;
            minCost+=e.cost;
            noofEdges++;
            addEdges(e.to);
        }

        return minCost;

    }

    public void addEdges(int node){

        visited[node]=true;
        List<Edge> list=graph[node];

        for(Edge e:list){
            if(!visited[e.to])
                pq.add(e);
        }


    }

    class Edge {

        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }

}
