package com.umair.dynamicprogramming.longestcommonsubsequence;

public class EditDistance {

    static int[][] cache;
    public static void main(String[] args) {

        String word1 = "intention", word2 = "execution";
        int m=word1.length();
        int n=word2.length();

        cache=new int[m+1][n+1];
        //recursive solution
        System.out.println(helper(word1,word2, m,n));

        //bottom up DP
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }

        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }

        System.out.println(dp[m][n]);


    }

    public static int helper(String word1, String word2, int m, int n){

        if(m==0)
            return n;

        if(n==0)
            return m;

        if(cache[m][n]!=0)
            return cache[m][n];

        if(word1.charAt(m-1)==word2.charAt(n-1)){
            return cache[m][n]=helper(word1,word2,m-1,n-1);
        }
        return cache[m][n]=1+Math.min(helper(word1,word2,m,n-1),//insertion
                Math.min(helper(word1,word2, m-1,n),//deletion
                        helper(word1,word2, m-1,n-1)));//replacement
    }
}
