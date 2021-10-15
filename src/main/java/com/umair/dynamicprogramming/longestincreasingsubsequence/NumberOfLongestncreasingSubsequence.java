package com.umair.dynamicprogramming.longestincreasingsubsequence;

import java.util.Arrays;

public class NumberOfLongestncreasingSubsequence {

    public static void main(String[] args) {
        Integer[] array={7, 6, 8, 10, 2, 5, 12, 30, 31, 20, 22,18};
        int cache[][]=new int[array.length][array.length];

        //DP method

        int lis[]=new int[array.length];
        int count[]=new int[array.length];
        lis[0]=1;
        Arrays.fill(count,1);
        int max=1;
        for(int i=1;i<array.length;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(array[i]>array[j]) {
                    if(lis[i]<1+lis[j]){
                        lis[i]=1+lis[j];
                        count[i]=count[j];
                    }
                    else if(lis[i]==lis[j]+1){
                        count[i]+=count[j];
                    }
                }
            }
            max=Math.max(max,lis[i]);
        }

        int result=0;

        for(int i=0;i<array.length;i++){
            if(lis[i]==max)
                result+=count[i];
        }
        System.out.println("LIS length:"+max);
        System.out.println("No of LIS with max length:"+result);

    }
}
