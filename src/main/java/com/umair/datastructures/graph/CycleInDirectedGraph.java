package com.umair.datastructures.graph;

import java.util.*;

public class CycleInDirectedGraph {
    static boolean flag=true;
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

        boolean[] visited = new boolean[N];
        boolean[] inRecursion = new boolean[N];

        for(int i=0;i<N;i++){
            if(!visited[i])
                System.out.println(dfs(graph,i,visited,inRecursion));

        }

        System.out.println(isCyclic(N,graph));

    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] inRecursion){

        visited[node] = true;
        inRecursion[node] = true;
        List<Integer> list=graph.get(node);
        for(int i=0;i<list.size();i++){
            int next=list.get(i);
            if(visited[next] && inRecursion[next] ){
                //there's a cycle
                return true;
            }
            if(!visited[next]){
                if(dfs(graph,next,visited,inRecursion)){
                    return true;
                }
            }

        }
        inRecursion[node] = false;
        return false;
    }

    //bFS method using Kahn's algorithm to detect cycle. If topological sort is not possible, it's cyclic.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {


        int[] inDegrees=new int[V];

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<V;i++){
            for(int v:adj.get(i)){
                inDegrees[v]++;
            }

        }

        int count =0;

        for(int i=0;i<V;i++){
            if(inDegrees[i]==0){
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int node =queue.poll();
            for(int v:adj.get(node)){
                inDegrees[v]--;
                if(inDegrees[v]==0){
                    queue.add(v);
                    count++;
                }
            }

        }

        return count==V?false:true;
    }
}
