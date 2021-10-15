package com.umair.dynamicprogramming.palindrome;

import java.util.Arrays;

public class MinimumInsertionToMakePalindrome {

    public static void main(String[] args) {

        String text1="mbadm";
        String text2=new StringBuilder(text1).reverse().toString();
        int A = text1.length();
        int B = text2.length();
        int cache[][]=new int[A][B];
        for(int[] i:cache) {
            Arrays.fill(i, -1);
        }
        int result=recursion(text1,text2,A-1,B-1,cache);
        System.out.println(text1.length()-result);

        //DP method
        int dp[][]=new int[A +1][B +1];
        dp[0][0]=0;
        for(int i = 1; i<=A; i++){
            for(int j = 1; j<=B; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        System.out.println(text1.length()-dp[A][B]);

    }

    public static int recursion(String s1, String s2, int i, int j, int[][] cache){
        if(i==-1 || j==-1){
            return 0;
        }
        if(cache[i][j]!=-1){
            return cache[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return cache[i][j]=1+recursion(s1,s2,i-1,j-1,cache);
        }
        else{
            return cache[i][j]=Math.max(recursion(s1,s2,i,j-1,cache),recursion(s1,s2,i-1,j,cache));
        }
    }

    }
