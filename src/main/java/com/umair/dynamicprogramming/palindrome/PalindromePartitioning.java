package com.umair.dynamicprogramming.palindrome;

import java.util.Arrays;

public class PalindromePartitioning {

    static int[][] dp;

    public static void main(String[] args) {

        String s="aaaaaaaaaaaaaaaaaaaaa";
        dp=new int[s.length()][s.length()];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int i=0;
        int j=s.length()-1;
        if(isPalindrome(s,i,j)){
            System.out.println(0);
        }
        else{
            System.out.println(solve(s,i,j));
        }


    }

    public static int solve(String s, int i,int j){

        if(isPalindrome(s,i,j)){
            return dp[i][j]=0;
        }

        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            if(isPalindrome(s,i,k)){
                int temp=1+solve(s,i,k);
                min=Math.min(min,temp);
            }


        }
        return dp[i][j]=min;

    }

    public static boolean isPalindrome(String s, int l, int r){

        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }

        return true;
    }

}
