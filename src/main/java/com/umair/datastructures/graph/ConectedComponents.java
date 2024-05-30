package com.umair.datastructures.graph;

import java.util.ArrayList;

public class ConectedComponents {

     static boolean[] visited;
     static int[] componentId;
     static int count;


    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        
        createGraph(graph);

        visited = new boolean[V] ;
        componentId = new int[V] ;
        count = 0;

        for(int v = 0; v<V; v++){
            if(!visited[v]) {
                dfs(v,graph);
                count++;
            }

        }

        System.out.println("No of connected Components:" +count);
    }

    private static void dfs(int v, ArrayList<Edge>[] graph) {

        visited[v] = true;
        componentId[v] = count;

        for(Edge edge:graph[v]) {
            if(!visited[edge.dest]){
                dfs(edge.dest, graph);
            }
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph) {

        for(int i=0;i<graph.length; i++){
            graph[i] = new ArrayList<>();

        }

        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,0));

        graph[4].add(new Edge(4,2));
        
    }

    static class Edge{

        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
}
