package com.umair.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequencePrint {

    public static void main(String[] args) {

        String text1="pmjghexybyrgzczy";
        String text2="hafcdqbgncrcbihkd";
        int A = text1.length();
        int B = text2.length();
        int cache[][]=new int[A][B];
        for(int[] i:cache) {
            Arrays.fill(i, -1);
        }

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
        int i=A;
        int j=B;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(sb.reverse());
    }

    }
