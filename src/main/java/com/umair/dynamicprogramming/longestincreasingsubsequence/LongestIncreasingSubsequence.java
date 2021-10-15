package com.umair.dynamicprogramming.longestincreasingsubsequence;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Integer[] array={7, 6, 8, 10, 2, 5, 12, 30, 31, 20, 22,18};
        int cache[][]=new int[array.length][array.length];
        System.out.println(rec(array,-1,0,cache));

        //DP method

        int dp[]=new int[array.length];
        dp[0]=1;
        int max=1;
        for(int i=1;i<array.length;i++){
           dp[i]=1;
            for(int j=0;j<i;j++){
                if(array[i]>array[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
       System.out.println(max);


    }

    private static int rec(Integer[] nums, int prev,int current,int[][] cache) {


        if(current==nums.length){
            return 0;
        }
        if(prev!=-1 && cache[prev][current]!=0){
            return cache[prev][current];
        }

       int op1=0,op2=0;
            if(prev==-1 || nums[current]>nums[prev]){
                op1=1+rec(nums,current,current+1,cache);
            }
           op2=rec(nums,prev,current+1,cache);
            if(prev!=-1)
            cache[prev][current]=Math.max(op1,op2);
            return Math.max(op1,op2);

    }



}
