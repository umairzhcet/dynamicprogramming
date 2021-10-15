package com.umair.dynamicprogramming.dfs;

public class GoldMine {
    static int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static int maxGold=0;
    public static void main(String[] args) {
        int[][] grid={{0,6,0},{5,8,7},{0,9,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    int gold=helper(grid,i, j);
                    maxGold=Math.max(maxGold,gold);
                }
            }
        }

        System.out.println(maxGold);
    }

    public static int helper(int[][] grid, int i,int j){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        int temp=grid[i][j];
        grid[i][j]=0;
        int gold=0;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            int currGold=helper(grid,x,y)+temp;
            gold=Math.max(gold,currGold);
        }
        grid[i][j]=temp;
        return gold;
    }
}
