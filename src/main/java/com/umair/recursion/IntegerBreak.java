package com.umair.recursion;

public class IntegerBreak {
    //LeetCode343
    static int[] cache;
    public static void main(String[] args) {
        int n=10;
        cache=new int[n+1];
        cache[1]=1;
        System.out.println(helper(n));
    }

    public static int helper(int n){

        if(n==0)
            return 0;

        if(cache[n]!=0)
            return Math.max(cache[n],n);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){

            max=Math.max(max,i*helper(n-i));
        }

        return cache[n]=max;
    }
}
