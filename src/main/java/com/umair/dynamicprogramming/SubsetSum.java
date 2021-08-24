package com.umair.dynamicprogramming;

public class SubsetSum {

    public static void main(String[] args) {
        int[] nums={2,3,5,6,8,10};
        int sum=10;
        System.out.println(bottomUp(nums,sum));
        System.out.println(recursiveSol(nums,sum,nums.length));

    }

    private static int recursiveSol(int[] nums, int sum, int length) {

       if(sum==0){
           return 1;
       }
       if(length==0){
           return 0;
       }
       if(nums[length-1]<=sum){
           return recursiveSol(nums,sum-nums[length-1],length-1)+recursiveSol(nums,sum,length-1);
       }
       else{
           return recursiveSol(nums,sum,length-1);
       }
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
