package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
//Course Schedule possible or not. Leetcode 207
    //similar to detect cycles in directed graph
    static boolean flag=true;
    public static void main(String[] args) {

        int numCourses=2;
        int[][] prerequisites={{1,0},{0,1}};
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(i,new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] cycle = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i])
                dfs(graph,i,visited,cycle);
            if(flag==false){
                System.out.println("Cycle is Present");
                return;
            }
        }

        System.out.println("Cycle is not present");
    }

    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] cycle){

        visited[node] = true;
        cycle[node] = true;
        List<Integer> list=graph.get(node);
        for(int i=0;i<list.size();i++){
            int next=list.get(i);
            if(cycle[next]){
                flag=false;
                return;
            }
            if(visited[next])continue;
            dfs(graph,next,visited, cycle);
        }
        cycle[node]=false;
    }
}
