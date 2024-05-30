package com.umair.datastructures.array.grid;

public class MaxAreaIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int r=grid.length;
        int c=grid[0].length;
        int max = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    int area =findArea(grid,i,j);
                    max = Math.max(max,area);
                }
            }
        }

        return max;



    }

    public static int findArea(int[][] grid, int i, int j) {

        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int count =1;
        count+=findArea(grid,i-1,j);
        count+=findArea(grid,i+1,j);
        count+=findArea(grid,i,j-1);
        count+=findArea(grid,i,j+1);

        return count;

    }
}
