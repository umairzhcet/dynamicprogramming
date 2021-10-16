package com.umair.datastructures.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestElements {
    public static void main(String[] args) {

        KClosestElements main=new KClosestElements();
        main.findClosestElements(new int[]{1,2,3,4,5},4,3).stream().forEach(System.out::println);
    }

    private List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-k;

        while(l<r){
            int mid=l+(r-l)/2;

            if(x-arr[mid]>arr[mid+k]-x)
                l=mid+1;
            else
                r=mid;
        }

        List<Integer> result=new ArrayList<>();
        for(int i=l;i<l+k;i++){
            result.add(arr[i]);
        }

        return result;

    }
}
