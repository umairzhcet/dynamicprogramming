package com.umair.dynamicprogramming.knapsack;

import java.util.Arrays;

public class CoinChangeTotalWays {


    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=5;
        System.out.println(coinChange(5,coins));
        int[][] cache=new int[501][5001];
        for (int[] row: cache)
            Arrays.fill(row, -1);
        System.out.println(recursiveSol(coins,amount,0,cache));


    }

    public static int coinChange(int amount, int[] coins) {

        int[][] dp=new int[coins.length+1][amount+1];

        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];

    }

    public static int recursiveSol(int[] coins,int amount,int index,int[][] cache){

        if(index==coins.length){
            return 0;
        }

        if(amount==0){
            return 1;
        }
        if(cache[index][amount]!=-1){
            return cache[index][amount];
        }
        int include=0;

        if(coins[index]<=amount){
            include=recursiveSol(coins,amount-coins[index],index,cache);
        }
        int exclude=recursiveSol(coins,amount,index+1,cache);
        return cache[index][amount]=include+exclude;
    }
}
