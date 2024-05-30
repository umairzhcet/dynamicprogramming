package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        RedundantConnection main = new RedundantConnection();
        int[] edge =main.findRedundantConnection(edges);
        System.out.println(Arrays.toString(edge));

    }

    public int[] findRedundantConnection(int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=edges.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            if(isCycle(graph,edge[0],-1,new boolean[edges.length+1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[]{};
    }

    private boolean isCycle(List<List<Integer>> graph, int current, int parent, boolean[] visited) {

        visited[current]=true;

        for(int adj:graph.get(current)){
            if(visited[adj] && adj!=parent){
                return true;
            }
            if(!visited[adj]){
                if(isCycle(graph,adj,current,visited)){
                    return true;
                }
            }

        }
        return false;
    }


}
