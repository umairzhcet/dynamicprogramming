package com.umair.dynamicprogramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Integer[] array={7, 6, 8, 10, 2, 5, 12, 30, 31, 20, 22,18};
        int cache[]=new int[array.length];
        System.out.println(rec(array,array.length-1,cache));



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

    private static int rec(Integer[] array, int index, int[] cache) {


        if(index==0){
            return 1;
        }
        if(cache[index]!=0){
            return cache[index];
        }
        int max=1;
        for(int j=0;j<index;j++){
            int lis=rec(array,j, cache);
            if(array[index]>array[j]){
                lis+=1;
            }
            max=Math.max(max,lis);

        }
      return cache[index]=max;
    }



}
