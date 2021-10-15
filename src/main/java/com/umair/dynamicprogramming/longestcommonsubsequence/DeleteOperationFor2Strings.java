package com.umair.dynamicprogramming.longestcommonsubsequence;

public class DeleteOperationFor2Strings {
    public static void main(String[] args) {

        String word1="pmjghexybyrgzczy";
        String word2="hafcdqbgncrcbihkd";
        int A=word1.length();
        int B=word2.length();
        if(word1.equals(word2)){
            System.out.println(0);
            return;
        }

        int dp[][]=new int[A +1][B +1];
        for(int i = 1; i<=A; i++){
            for(int j = 1; j<=B; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        System.out.println(A-dp[A][B] + B-dp[A][B]);
    }
}
