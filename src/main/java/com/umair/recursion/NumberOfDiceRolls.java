package com.umair.recursion;

import java.util.Arrays;

public class NumberOfDiceRolls {
    int constVal = 1000000007;

    public static void main(String[] args) {

        int n =2;
        int k=6;
        int target=7;

        System.out.println(new NumberOfDiceRolls().numRollsToTarget(n,k,target));

    }

    public int numRollsToTarget(int n, int k, int target) {

        int[][] mem = new int[n+1][target+1];
        for (int[] row: mem)
        Arrays.fill(row,-1);

         return helper(n,target, k,mem);

    }

    private int helper(int n , int target, int k, int[][] mem){

        if(n==0){
            return target==0?1:0;
        }

        if(mem[n][target]!=-1){
            return mem[n][target];
        }

        int sum =0;
        for(int i=1;i<=k && i<=target;i++){
            sum=(sum+helper(n-1,target-i,k,mem))%constVal;

        }

        return mem[n][target]=sum%constVal;
    }


}
