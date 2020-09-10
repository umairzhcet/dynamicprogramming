package com.umair.dynamicprogramming;

public class EqualPartitionSubset {

    public static void main(String[] args) {

        int[] nums={1,5,11,5};

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==0){
            System.out.println(bottomUp(nums,sum/2));
        }

    }

    public static boolean bottomUp(int[] nums,int sum){

        boolean[][] dp=new boolean[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j]=false;
                    continue;
                }
                if(j==0){
                    dp[i][j]=true;
                    continue;
                }
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[nums.length][sum];

    }

    public boolean topDown(int[] nums,int mid,int index,Boolean[][] valid){

        if(index==nums.length || mid<0){

            return false;

        }
        else if(mid==0){

            return true;

        }
        if(valid[index][mid]!=null){

            return valid[index][mid];

        }

        return valid[index][mid]=topDown(nums,mid,index+1,valid)
                || topDown(nums,mid-nums[index],index+1,valid);

    }
}
