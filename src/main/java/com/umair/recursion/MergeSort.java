package com.umair.recursion;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr ={8,3,4,12,5,6};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start<end){
            int mid =start+(end-start)/2;
            mergeSort(arr,0,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);

        }

    }

    private static void merge(int[] arr, int start, int mid, int end) {

        int n1 =mid-start+1;
        int n2=end-mid;

        int[] left =new int[n1];
        int[] right =new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[start+i];
        }
        for(int i=0;i<n2;i++){
            right[i]=arr[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=start;

        while(i<n1 && j<n2){

            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }
            else{
                arr[k++]=right[j++];
            }

        }

        while(i<n1){
            arr[k++]=left[i++];
        }
        while(j<n2){
            arr[k++]=right[j++];
        }
    }
}
