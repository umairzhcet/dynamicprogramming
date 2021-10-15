package com.umair.dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {

        int[] nums={1,2,7};
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        //range of difference will lie from 0 to sum
        int[] range=bottomUp(nums,sum);
        // fetching last row of dp--will give ranges from sum 0 to sum
        List<Integer> difference=new ArrayList<>();
        for(int i=0;i<=range.length/2;i++){
            if(range[i]==1){
                difference.add(i);
            }
        }
        //two partitions s1 and s2 will add upto sum
        //s1+s2=range or s2=range-s1
        //minimise s2-s1  or range-s1-s1 or range-2*s1
        int min=Integer.MAX_VALUE;
        for(int num:difference){
            min=Math.min(min,sum-2*num);
        }
        System.out.println(min);

    }

    public static int[] bottomUp(int[] nums,int sum){

        int[][] dp=new int[nums.length+1][sum+1];

        for(int i=0;i<=nums.length;i++ ){
            dp[i][0]=1;
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j] | dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[nums.length];

    }
}
