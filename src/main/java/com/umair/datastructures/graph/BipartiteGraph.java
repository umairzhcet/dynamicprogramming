package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) {

            int N=4;

            int[][] edges={{0,1},{1,2},{2,3},{3,1}};
            ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

            for(int i=0;i<N;i++){
                graph.add(i,new ArrayList<>());
            }

            for(int[] edge:edges){
                graph.get(edge[0]).add(edge[1]);
            }

            System.out.println(isBipartite(N,graph));
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj)
    {

        int[] color =new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(adj,i,1,color)==false){
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int current, int currentColor, int[] color){

        color[current] =currentColor;

        for(int v:adj.get(current)){

            if(color[v]==color[current]){
                return false;
            }

            if(color[v]==-1){
                int nextColor=1-currentColor;
                if(dfs(adj,v,nextColor,color)==false){
                    return false;
                }

            }

        }

        return true;

    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int current, int currentColor, int[] color)
    {
        Queue<Integer> queue = new LinkedList<>();
        color[current]=currentColor;
        queue.add(current);

        while(!queue.isEmpty()){
            int node =queue.poll();
            for(int v:adj.get(node) ){
                if(color[v]==color[node]){
                    return false;
                }
                if(color[v]==-1){
                    color[v]=1-color[node];
                    queue.add(v);
                }
            }
        }

        return true;

    }
}
