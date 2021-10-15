package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalSectionsOrBridges {

    private static List<List<Integer>> bridges;
    private static int id=0;
    private static int[] low;
    private static int[] ids;
    public static void main(String[] args) {

        //input
        int n=4;
        List<List<Integer>> connections=new ArrayList<>();
        connections.add(Arrays.asList(new Integer[] { 0,1 }));
        connections.add(Arrays.asList(new Integer[] { 1,2 }));
        connections.add(Arrays.asList(new Integer[] { 2,0 }));
        connections.add(Arrays.asList(new Integer[] { 1,3 }));


        bridges=new ArrayList<>();
        List<Integer>[] graph=new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for(List<Integer> edges:connections){
            graph[edges.get(0)].add(edges.get(1));
            graph[edges.get(1)].add(edges.get(0));
        }
        low=new int[n];
        ids=new int[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,-1,graph,visited);
            }
        }

        System.out.println(bridges);

    }

    public static void dfs(int node, int parent, List<Integer>[] graph, boolean[] visited){

        visited[node]=true;
        low[node]=ids[node]=++id;

        List<Integer> list=graph[node];
        for(int next:list){
            if(next==parent) continue;

            if(!visited[next]){
                dfs(next,node,graph,visited);
                low[node]=Math.min(low[node],low[next]);
                if(ids[node]<low[next]){
                    List<Integer> bridge=new ArrayList<>();
                    bridge.add(node);
                    bridge.add(next);
                    bridges.add(bridge);
                }
            }
            else{
                low[node]=Math.min(low[node],ids[next]);
            }
        }
    }
}
