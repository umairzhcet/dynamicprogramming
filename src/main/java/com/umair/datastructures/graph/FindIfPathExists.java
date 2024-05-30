package com.umair.datastructures.graph;

import java.util.ArrayList;

public class FindIfPathExists {

    public static void main(String[] args) {

        int n =10;
        int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        int source =5;
        int destination =9;

        ArrayList<int[]> graph[] =new ArrayList[n];
        boolean[] viisted = new boolean[n];

        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph[u].add(new int[]{u,v});
            graph[v].add(new int[]{v,u});
        }

        System.out.println(new FindIfPathExists().validPath(n,graph,source,destination,viisted));


    }

    public boolean validPath(int n, ArrayList<int[]>[] edges, int source, int destination,boolean[] visited) {

        return dfs(edges, source, destination,visited);

    }

    public boolean dfs(ArrayList<int[]>[] graph, int source, int destination, boolean[] visited){

        if(source==destination){
            return true;
        }
        if(visited[source]){
            return false;
        }

        visited[source]=true;

        for(int[] edge: graph[source]){

            if(dfs(graph, edge[1], destination, visited)){
                return true;
            }

        }

        return false;
    }
}
