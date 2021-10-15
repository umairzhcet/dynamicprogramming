package com.umair.dynamicprogramming.palindrome;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        // code not passing for all the test cases

        String s="aacabdkacaa";
        String rev=new StringBuilder(s).reverse().toString();

        int A=s.length();
        int B=rev.length();
        int[][] dp=new int[A+1][B+1];
        int max=Integer.MIN_VALUE;
        int m=0;
        int n=0;

        for(int i=1;i<=A;i++){
            for(int j=1;j<=B;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max=dp[i][j];
                        m=i;
                        n=j;
                    }
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        String result=s.substring(m-max,m);


        System.out.println(result);

    }


    }
