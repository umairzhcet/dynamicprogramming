package com.umair.dynamicprogramming.leetcode;

public class HouseRobber {


    public static void main(String[] args) {

        int houses[]={20,25,30,15,10};
        int cache[]=new int[houses.length];
        System.out.println(recursiveSol(houses,0,cache));


        //DP method
        int dp[]=new int[houses.length+1];;
        dp[1]=houses[0];

        for(int i=2;i<=houses.length;i++){
            dp[i]=Math.max(houses[i-1]+dp[i-2],dp[i-1]);
        }
        System.out.println(dp[houses.length]);
    }

    private static int recursiveSol(int[] houses, int i, int[] cache) {

        if(i>=houses.length){
            return 0;
        }
        if(cache[i]!=0){
            return cache[i];
        }
        return  cache[i]=Math.max(houses[i]+recursiveSol(houses,i+2, cache),recursiveSol(houses,i+1, cache));
    }
}