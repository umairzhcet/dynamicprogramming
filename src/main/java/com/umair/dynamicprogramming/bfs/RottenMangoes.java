package com.umair.dynamicprogramming.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottenMangoes {

    public static void main(String[] args) {

        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int min = orangesRotting(grid);
        System.out.println(min);

    }

    public static int orangesRotting(int[][] grid) {

        int time =0;
        int fresh =0;
        Queue<int[]> q= new LinkedList<>();
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }

            }

        }
        if(fresh==0){
            return 0;
        }
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size= q.size();
            time++;
            for(int i=0;i<size;i++){
                int[] rotten= q.poll();
                for(int[] dir: directions){
                    int x= rotten[0]+dir[0];
                    int y= rotten[1]+dir[1];
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!=1){
                        continue;
                    }
                    q.add(new int[]{x,y});
                    grid[x][y]=2;
                    fresh--;

                }
            }

        }
        return fresh==0?time-1:-1;
    }
}
