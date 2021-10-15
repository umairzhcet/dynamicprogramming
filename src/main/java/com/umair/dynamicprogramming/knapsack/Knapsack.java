package com.umair.dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {

        Integer[] values={60, 100, 120};
        Integer[] weights = {10, 20, 30};
        int C = 50;
        ArrayList<Integer> A =new ArrayList<>(Arrays.asList(values));
        ArrayList<Integer> B =new ArrayList<>(Arrays.asList(weights));
        int mm[][]=new int[C+1][A.size()];
        int maxValue = recursiveSolution(A,B,C,A.size()-1,mm);
        System.out.println(maxValue);

        //dp method
        int dp[][]=new int[C+1][A.size()+1];
        //dp[0][0]=0;

        for(int w=1;w<=C;w++) {
            for (int i = 1; i<=A.size(); i++) {

                if(B.get(i-1)<=w){
                    dp[w][i]=Math.max(A.get(i-1)+dp[w-B.get(i-1)][i-1],dp[w][i-1]);
                }
                else{
                    dp[w][i]=dp[w][i-1];
                }

            }
        }
        System.out.println(dp[C][A.size()]);
    }

    public static int recursiveSolution(ArrayList<Integer> A, ArrayList<Integer> B, int C, int index, int mm[][]){

        if(index==-1 || C==0){
            return 0;
        }
        if(mm[C][index]!=0){
            return mm[C][index];
        }

        if(B.get(index)<=C){
            int include=A.get(index)+recursiveSolution(A,B,C-B.get(index),index-1,mm);
            int exclude=recursiveSolution(A,B,C,index-1,mm);
            mm[C][index] =Math.max(include,exclude);
            return mm[C][index];
        }
        else{
            return mm[C][index]=recursiveSolution(A,B,C,index-1,mm);
        }
    }
}
