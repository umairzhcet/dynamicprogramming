package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInUnDirectedGraph {


    static boolean flag=true;
    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) {

        int N=4;

        int[][] edges={{0,1},{1,2},{2,3},{3,1}};
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<N;i++){
            graph.add(i,new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++){
            if(!visited[i])
                System.out.println(dfs(graph,i,-1,visited));

        }

        System.out.println(isCycle(N,graph));

    }

    public static boolean dfs(List<List<Integer>> graph, int node, int parent, boolean[] visited){

        visited[node] = true;
        List<Integer> list=graph.get(node);
        for(int i=0;i<list.size();i++){
            int next=list.get(i);
            if(visited[next] && next!=parent ){
                //there's a cycle
                return true;
            }
            if(!visited[next]){
                if(dfs(graph,next,node,visited)){
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {
        parent = new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }

        for(int x=0;x<V;x++){
            for(int y:adj.get(x)){
                if(x<y){
                    if(find(x)==find(y)){
                        return true;
                    }
                    union(x,y);
                }

            }
        }

        return false;


    }

    public static int find(int x){

        if(parent[x]==x){
            return x;
        }

        return parent[x]=find(parent[x]);
    }

    public static void union(int x, int y){
        int x_parent=find(x);
        int y_parent=find(y);

        if(x_parent!=y_parent){
            if(rank[x]>rank[y]){
                parent[y]=parent[x];
            }
            else if(rank[x]<rank[y]){
                parent[x]=parent[y];
            }
            else{
                parent[y]=parent[x];
                rank[x]++;
            }
        }

    }
}
