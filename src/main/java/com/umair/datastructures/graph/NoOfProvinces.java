package com.umair.datastructures.graph;

import java.util.ArrayList;

public class NoOfProvinces {

    public static void main(String[] args) {
        int V =2;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(i,new ArrayList<>());
        }
        adj.get(0).add(0);
        adj.get(1).add(1);
        System.out.println(numProvinces(adj,V));

    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {


        boolean[] visited =new boolean[V];
        int provinces=0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                provinces++;
                dfs(adj,i,visited);

            }
        }

        return provinces;


    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int city, boolean[] visited){

        visited[city]=true;

        for(int v:adj.get(city)){

            if(!visited[v]){
                dfs(adj,v,visited);
            }
        }
    }
}
