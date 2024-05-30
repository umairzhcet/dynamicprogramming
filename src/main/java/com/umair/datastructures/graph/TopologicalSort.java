package com.umair.datastructures.graph;

import java.util.*;
import java.util.stream.IntStream;

public class TopologicalSort {

    public static void main(String[] args) {

        int V =6;

        int[][] edges={{5,0},{5,2},{4,0},{4,1},{1,3},{2,3}};
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<V;i++){
            graph.add(i,new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
        }
        IntStream.of(topoSort2(V,graph)).forEach(System.out::println);


    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj, i,visited, stack);

            }
        }
        int[] result = new int[stack.size()];
        int k=0;
        while(!stack.isEmpty()){
            result[k++]=stack.pop();
        }

        return result;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack){

        visited[u]=true;

        for(Integer v:adj.get(u)){
            if(!visited[v]){
               dfs(adj,v,visited, stack);
            }
        }

        stack.push(u);

    }


    //BFS method for Topological Sorting,also known as Kahn's Algorithm
    static int[] topoSort2(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here

        Queue<Integer> queue = new LinkedList<>();
        //calculate indegrees
        int[] inDegrees=new int[V];

        for(int i=0;i<V;i++){
            for(int v:adj.get(i)){
                inDegrees[v]++;

            }
        }

       // store 0 inDegrees nodes in queue
        for(int i=0;i<V;i++){
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }

        int[] result =new int[V];
        int k =0;
        while(!queue.isEmpty()){
            Integer node =queue.poll();
            result[k++]=node;

            for(int v: adj.get(node)){
                inDegrees[v]--;
                if(inDegrees[v]==0){
                    queue.add(v);
                }
            }

        }

       return result;
    }
}
