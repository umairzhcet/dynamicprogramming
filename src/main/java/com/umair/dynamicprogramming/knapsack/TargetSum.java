package com.umair.dynamicprogramming.knapsack;

public class TargetSum {

    public static void main(String[] args) {


        int[] nums={1,1,1,1,1};
        int target=3;
        int sum=0;
        for(int i=0;i<nums.length;i++){
          sum+=nums[i];
        }
        //s1+s2=sum;
        //s1-s2=target
        //s1=sum+target/2

        System.out.println(bottomUp(nums,(target+sum)/2));



    }

    public static int bottomUp(int[] nums,int sum){

        int[][] dp=new int[nums.length+1][sum+1];

        for(int i=0;i<=nums.length;i++ ){
            dp[i][0]=1;
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[nums.length][sum];

    }

}
