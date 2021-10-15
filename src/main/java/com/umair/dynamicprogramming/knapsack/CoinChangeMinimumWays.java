package com.umair.dynamicprogramming.knapsack;

public class CoinChangeMinimumWays {

    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
        //bottomUp DP approach
        int result=coinChange(coins,amount);
        //topdown recursive approach
        int[][]cache=new int[coins.length+1][amount+1];
        result=recursiveSol(coins,amount,0,cache);
        System.out.println(result==Integer.MAX_VALUE?-1:result);

    }

    public static int coinChange(int[] coins, int amount) {

         int[][] dp=new int[coins.length+1][amount+1];

         for(int i=0;i<=amount;i++){
             dp[0][i]=Integer.MAX_VALUE-1;
         }

         for(int i=1;i<=coins.length;i++){

             for(int j=1;j<=amount;j++){

                 if(coins[i-1]<=j){
                     dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                 }
                 else{
                     dp[i][j]=dp[i-1][j];
                 }
             }
         }

        return dp[coins.length][amount];



    }

    public static int recursiveSol(int[] input,int target,int index,int[][]cache){

        if(index==input.length){
            return Integer.MAX_VALUE-1;
        }
        if(target==0){
            return 0;
        }
        if(cache[index][target]!=0){
            return cache[index][target];
        }
        if(input[index]<=target){
            int a=recursiveSol(input,target,index+1,cache);
            int b=1+recursiveSol(input,target-input[index], index,cache);
            return cache[index][target]=Math.min(a,b);
        }
        else{
            return cache[index][target]=recursiveSol(input,target,index+1,cache);
        }


    }
}
