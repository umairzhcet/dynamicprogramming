package com.umair.dynamicprogramming;

import java.time.Instant;

public class PaintingHouse {

    public static void main(String[] args) {

        int[][] cost={{17,12,17},{16,16,25},{14,13,19}};
        int cache[][]=new int[cost.length][3];
        int red=recursiveSolution(cost,0,0,cache);
        int blue=recursiveSolution(cost,1,0,cache);
        int green=recursiveSolution(cost,2,0,cache);

        System.out.println(Math.min(red,Math.min(blue,green)));

        //DP method
        int dp [][]=new int[cost.length+1][cost[0].length];

        for(int i=1;i<=cost.length;i++) {
            //RED
            dp[i][0] = cost[i - 1][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            //BLUE
            dp[i][1] = cost[i - 1][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);

            //GREEN
            dp[i][2] = cost[i - 1][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        System.out.println(Math.min(dp[cost.length][0], Math.min(dp[cost.length][1], dp[cost.length][2])));
    }

    private static int recursiveSolution(int[][] cost, int color, int i, int[][] cache) {

        if (i == cost.length) {
            return 0;
        }

        if(cache[i][color]!=0){
            return cache[i][color];
        }
        switch (color) {
            case 0: {
                return cache[i][color]=cost[i][0] + Math.min(recursiveSolution(cost, 1, i + 1, cache), recursiveSolution(cost, 2, i + 1, cache));
            }
            case 1: {
                return cache[i][color]=cost[i][1] + Math.min(recursiveSolution(cost, 0, i + 1, cache), recursiveSolution(cost, 2, i + 1, cache));
            }
            case 2: {
                return cache[i][color]=cost[i][2] + Math.min(recursiveSolution(cost, 0, i + 1, cache), recursiveSolution(cost, 1, i + 1, cache));
            }
        }

       return 0;
    }
}
