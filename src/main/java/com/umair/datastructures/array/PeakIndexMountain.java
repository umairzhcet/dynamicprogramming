package com.umair.datastructures.array;

public class PeakIndexMountain {

    public static void main(String[] args) {
        PeakIndexMountain main=new PeakIndexMountain();
        System.out.println(main.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));

    }
    public int peakIndexInMountainArray(int[] arr) {

        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(arr[mid]<arr[mid+1]){
                i=mid+1;
            }
            else if(arr[mid]>arr[mid+1]){
                j=mid-1;

            }

        }

        return i;
    }
}
