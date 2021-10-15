package com.umair.dynamicprogramming.leetcode;

import java.util.Arrays;

public class JumpGame2 {


    static int[] cache;
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};

        // greedy method

        int steps=0;
        int nextEnd=0;
        int currEnd=0;

        for(int i=0;i<nums.length-1;i++){
            nextEnd=Math.max(nextEnd,i+nums[i]);
            if(i==currEnd){
                steps++;
                currEnd=nextEnd;
            }
        }

        System.out.println("Steps using Greedy method:"+steps);

        //using recursive method
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        System.out.println(helper(nums,0,dp));


    }

    public static int helper(int[] nums,int pos,int[] dp){

        if(pos>=nums.length-1){
            return 0;
        }
        if(dp[pos]!=-1){
            return dp[pos];
        }
        int range=pos+nums[pos];
        if(range>=nums.length-1){
            return 1;
        }

        int min=10000;
        for(int i=pos+1;i<=range;i++){
            min = Math.min(min,(1+helper(nums,i,dp)));

        }
        return dp[pos]=min;
    }
}
