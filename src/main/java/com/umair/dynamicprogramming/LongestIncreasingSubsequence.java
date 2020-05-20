package com.umair.dynamicprogramming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Integer[] array={5,2,7,3,6,8};
        int cache[]=new int[array.length];
        System.out.println(recursiveSol(array,array.length-1,cache));

        //DP method


        int dp[]=new int[array.length+1];
        dp[0]=1;
        for(int i=1;i<array.length;i++){

            dp[i]=1;
            for(int j=0;j<i;j++){
                int lis=dp[j];
                if(array[i]>array[j]){
                    lis+=1;
                }
                dp[i]=Math.max(dp[i],lis);
            }
        }
        System.out.println(dp[array.length-1]);
    }

    private static int recursiveSol(Integer[] array, int index, int[] cache) {


        if(index==0){
            return 1;
        }
        if(cache[index]!=0){
            return cache[index];
        }
        int max=0;
        for(int j=0;j<index;j++){
            int lis=recursiveSol(array,j, cache);
            if(array[index]>array[j]){
                lis+=1;
            }
            max=Math.max(max,lis);
        }
        return cache[index]=max;
    }


}
