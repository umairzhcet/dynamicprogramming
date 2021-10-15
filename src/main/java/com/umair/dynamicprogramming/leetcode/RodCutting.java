package com.umair.dynamicprogramming.leetcode;

public class RodCutting {

    public static void main(String[] args) {
        Integer[] cost={1,5,8,9,10,14,17,20,24,30};
        int[] cache=new int[cost.length+1];
        int length=8;
        System.out.println(recursiveSol(length,cost,cache));

        //DP method
        int[] dp=new int[length+1];
        int[] cuts=new int[length+1];

        for(int i=1;i<=length;i++){
            dp[i]=Integer.MIN_VALUE;
            int cut=-1;
            for(int j=0;j<i;j++){
                if(cost[j]+dp[i-j-1]>dp[i]){
                    dp[i]=cost[j]+dp[i-j-1];
                    cut=j+1;
                }

            }
            cuts[i]=cut;
        }
        System.out.println(dp[length]);
        int cut=cuts[length];
       while(cut!=0){
           System.out.println("cut"+cut+" ");
           length=length-cut;
           cut=cuts[length];

       }
    }

    private static int recursiveSol(int length, Integer[] cost, int[] cache) {
        if(length==0){
            return 0;
        }
        if(cache[length]!=0){
            return cache[length];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            max= Math.max(max,cost[i]+recursiveSol(length-i-1, cost, cache));
        }
        return cache[length]=max;

    }
}
