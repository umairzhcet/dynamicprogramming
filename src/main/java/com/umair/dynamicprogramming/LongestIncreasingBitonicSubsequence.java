package com.umair.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingBitonicSubsequence {

    public static void main(String[] args) {
        Integer[] a={7, 6, 8, 10, 2, 5, 12, 30, 31, 20, 22, 18};
        int size = a.length;
        int lis[]=new int[size];
        int lds[]=new int[size];
        int max=0;
        lis[0]=1;
        for(int i = 1; i< size; i++){
            lis[i]=1;

            for(int j=0;j<i;j++){
                int x=lis[j];
                if(a[i]>a[j] && x+1>lis[i]){
                    lis[i]=lis[j]+1;
                }
            }

        }
        System.out.println(Arrays.toString(lis));
        lds[size-1]=1;
        for(int i = size -2; i>=0; i--){
            lds[i]=1;

            for(int j = size -1; j>i; j--){
                int y=lds[j];
                if(a[i]>a[j]){
                    y+=1;
                }
                lds[i]=Math.max(lds[i],y);
            }

        }
        System.out.println(Arrays.toString(lds));
        for(int k = 0; k< size; k++){
            int sum=lis[k]+lds[k]-1;
            max=Math.max(max,sum);
        }

        System.out.println(max);

    }

}
