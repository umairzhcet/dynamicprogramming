package com.umair.dynamicprogramming.longestcommonsubsequence;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String text1="abchjk";
        String text2="abghabcpk";
        int A = text1.length();
        int B = text2.length();
        int cache[][]=new int[A][B];
        for(int[] i:cache) {
            Arrays.fill(i, -1);
        }
        int count=recursiveSol(text1,text2, A -1, B -1,0);
        System.out.println(count);

        //DP method
        int dp[][]=new int[A +1][B +1];
        int max=Integer.MIN_VALUE;
        for(int i = 1; i<=A; i++){
            for(int j = 1; j<=B; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]= 0;
                }

            }
        }
        System.out.println(max);
    }


    public static int recursiveSol(String text1, String text2, int i, int j,int count) {
        {

            if(i==-1 || j==-1){
                return count;
            }

            if(text1.charAt(i)==text2.charAt(j)){
                return count=recursiveSol(text1,text2,i-1,j-1,count+1);
            }
            else{
               return count=Math.max(recursiveSol(text1,text2,i,j-1,0),recursiveSol(text1,text2,i-1,j,0));
            }
        }
    }
    }
