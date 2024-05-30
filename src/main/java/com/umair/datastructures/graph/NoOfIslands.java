package com.umair.datastructures.graph;

public class NoOfIslands {

    public static void main(String[] args) {
       char[][] grid = {
               {'1', '1', '0', '0', '0'},
               {'1', '1', '0', '0', '0'},
               {'0', '0', '1', '0', '0'},
               {'0', '0', '0', '1', '1'}
        };

        NoOfIslands main = new NoOfIslands();
        System.out.println(main.numIslands(grid));

    }

    public int numIslands(char[][] grid) {

        int count =0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count+=dfs(grid,i,j);
                }
            }
        }

        return count;

    }

    private int dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]=='0'){
            return 0;
        }

        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

        return 1;

    }
}
