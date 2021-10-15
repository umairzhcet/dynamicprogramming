package com.umair.dynamicprogramming.leetcode;

public class MinimumCostPath {

    public static void main(String[] args) {

        int grid[][]={{1,3,1},{1,5,1},{4,2,1}};

        int cache[][]=new int[grid.length][grid[0].length];
        int min=recursiveSol(grid,grid.length-1,grid[0].length-1,cache);
        System.out.println(min);

        //DP method
        int dp[][]=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    continue;
                }
                dp[i][j]=Integer.MAX_VALUE;
                if(i>0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                if(j>0){
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        System.out.println(dp[grid.length-1][grid[0].length-1]);
    }

    public static int recursiveSol(int[][] grid,int i,int j,int[][] cache){

        if(i==0 && j==0){
            return grid[i][j];
        }
        if(cache[i][j]!=0){
            return cache[i][j];
        }

        int min=Integer.MAX_VALUE;
        if(i>0){
            min=recursiveSol(grid,i-1,j,cache)+grid[i][j];
        }
        if(j>0){
            min=Math.min(min,recursiveSol(grid,i,j-1,cache)+grid[i][j]);
        }
        return cache[i][j]=min;
    }

}
