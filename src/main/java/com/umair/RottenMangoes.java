package com.umair;

import java.util.HashSet;
import java.util.Set;

public class RottenMangoes {

    public static void main(String[] args) {

        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        int min=orangesRotting(grid);
        System.out.println(min);

    }

    public static int orangesRotting(int[][] grid) {

        Set<String > rotten=new HashSet<>();
        Set<String> fresh=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    rotten.add(""+i+j);
                }
                else if(grid[i][j]==1){
                    fresh.add(""+i+j);
                }
            }
        }
        int minutes=0;
        int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
        while(!fresh.isEmpty()){
            Set<String> infected=new HashSet<>();
            for (String s:rotten){
                int i=s.charAt(0)-'0';
                int j=s.charAt(1)-'0';
                for(int[] d:directions){
                  String newPos=""+(i+d[0])+(j+d[1]);
                    if(fresh.contains(newPos)){
                        fresh.remove(newPos);
                        infected.add(newPos);
                    }
                }

            }
            if(infected.size()>0){
                minutes++;
                rotten=infected;
            }
            else{
                return -1;
            }
        }
            return minutes;
    }
}
