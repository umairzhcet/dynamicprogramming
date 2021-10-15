package com.umair.dynamicprogramming.longestcommonsubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String text1="pmjghexybyrgzczy";
        String text2="hafcdqbgncrcbihkd";
        int A = text1.length();
        int B = text2.length();
        int cache[][]=new int[A][B];
        for(int[] i:cache) {
            Arrays.fill(i, -1);
        }
        int max=recursiveSol(text1,text2, A -1, B -1,cache);
        System.out.println(max);

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
        System.out.println(dp[A][B]);
    }


    public static int recursiveSol(String text1, String text2, int i, int j, int[][] cache) {
        {

            if(i==-1 || j==-1){
                return 0;
            }
            if(cache[i][j]!=-1){
                return cache[i][j];
            }

            if(text1.charAt(i)==text2.charAt(j)){
                return cache[i][j]=1+recursiveSol(text1,text2,i-1,j-1, cache);
            }
            else{
                return cache[i][j]=Math.max(recursiveSol(text1,text2,i,j-1, cache),recursiveSol(text1,text2,i-1,j, cache));
            }
        }
    }
    }
