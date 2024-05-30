package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsDAG {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        AllPathsDAG main = new AllPathsDAG();

        // Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]

        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};

        List<List<Integer>> result= main.allPathsSourceTarget(graph);
        System.out.println(result);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int source = 0;
        int target = graph.length-1;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,0,target,path);
        return result;

    }

    public void dfs(int[][] graph, int current, int target, List<Integer> path){

        if(current==target){
            result.add(new ArrayList<>(path));

        }

        for(int i=0;i<graph[current].length;i++){
            int node = graph[current][i];
            path.add(node);
            dfs(graph,node,target,path);
            path.remove(path.size()-1);

        }
    }
}
