package com.umair.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    //find course schedule
    private static final int NOT_STARTED = 0;
    private static final int IN_PROGRESS = 1;
    private static final int COMPLETED = 2;
    private static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) {

        //input
        int numCourses=4;
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};

        List<Integer>[] graph=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        //create adjacency list

        for(int[] edge:prerequisites){
            graph[edge[1]].add(edge[0]);
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==NOT_STARTED){
                if(dfs(graph,i,visited)){
                    System.out.println(new int[0]);
                }
            }
        }

        int[] result=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            result[i++]=stack.pop();
        }

        Arrays.stream(result).forEach(System.out::println);

    }

    public static boolean dfs(List<Integer>[] graph, int node, int[] visited){
        visited[node] = IN_PROGRESS;
        List<Integer> list=graph[node];

        for(int i=0;i<list.size();i++){
            int next=list.get(i);
            if(visited[next]==IN_PROGRESS){
                return true;
            }
            if(visited[next]==NOT_STARTED){
                if(dfs(graph,next,visited)){
                    return true;
                }
            }
        }

        stack.push(node);
        visited[node]=COMPLETED;
        return false;
    }

}
