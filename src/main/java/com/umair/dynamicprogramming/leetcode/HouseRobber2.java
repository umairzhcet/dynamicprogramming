package com.umair.dynamicprogramming.leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;

public class HouseRobber2 {

// houses are circular, firt and last house are neighbours
    public static void main(String[] args) {

        int houses[]={20,25,30,15,10};
        int max=0;
        if(houses.length==1){
            max= houses[0];
        }
        if(houses.length==2){
            max= Math.max(houses[0],houses[1]);
        }
        int[] cache1=new int[houses.length];
        Arrays.fill(cache1,-1);

        int[] cache2=new int[houses.length+1];
        Arrays.fill(cache2,-1);

        int res1=helper(houses,0,houses.length-1,cache1);
        int res2=helper(houses,1,houses.length,cache2);
        max=Math.max(res1,res2);
        System.out.println("Recursive answer:"+max);

        //DP method


        int maxAmount=houses[0];
        int[] dp1=new int[houses.length];
        int[] dp2=new int[houses.length+1];
        dp1[1]=houses[0];
        dp1[2]=houses[0];
        for(int i=3;i<=houses.length-1;i++){
            dp1[i]=Math.max(dp1[i-2]+houses[i-1],dp1[i-1]);
            maxAmount=Math.max(maxAmount,dp1[i]);
        }
        dp1[1]=0;
        for(int i=2;i<=houses.length;i++){
            dp2[i]=Math.max(dp2[i-2]+houses[i-1],dp2[i-1]);
            maxAmount=Math.max(maxAmount,dp2[i]);
        }

        System.out.println("DP answer:"+maxAmount);

    }

    private static int helper(int[] nums, int i, int end, int[] cache){

        if(i>=end){
            return 0;
        }
        if(cache[i]!=-1){
            return cache[i];
        }

        return cache[i]=Math.max(nums[i]+helper(nums,i+2,end,cache),
                helper(nums,i+1,end,cache));

    }
}