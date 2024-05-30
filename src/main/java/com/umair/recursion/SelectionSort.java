package com.umair.recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        selectionSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectionSort(int[] arr, int r, int c, int maxSoFar) {
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[maxSoFar]){
                selectionSort(arr,r,c+1,c);
            }
            else{
                selectionSort(arr,r,c+1,maxSoFar);
            }
        }
        else{
            int temp =arr[maxSoFar];
            arr[maxSoFar]=arr[r-1];
            arr[r-1]=temp;
            selectionSort(arr,r-1,0,0);
        }

    }
}
