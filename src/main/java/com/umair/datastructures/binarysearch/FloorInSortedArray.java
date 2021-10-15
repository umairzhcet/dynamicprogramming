package com.umair.datastructures.binarysearch;

public class FloorInSortedArray {

    public static void main(String[] args) {


        int[] nums={35 ,36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46 ,47, 48, 49, 50, 51, 52 ,53, 54, 55, 56, 57, 58 ,59 ,60, 61, 62, 63, 64 ,65, 66, 67, 68 ,69, 70, 71,
                72, 73, 74 ,75, 76 ,77 ,78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96 ,97 ,98 ,99 ,100, 101, 102, 103 ,104, 105,
                106, 107, 108, 109, 110, 111 ,112, 113
        };
        int element=159;

        System.out.println(findFloor(nums,element));
    }

    public static int findFloor(int[] nums,int element){

        int start=0;
        int end=nums.length-1;
        int floor=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==element){
                //return nums[mid];
                return mid;
            }
            else if(nums[mid]>element){
                end=mid-1;
            }
            else{
                //floor=nums[mid];
                floor=mid;
                start=mid+1;
            }

        }

        return floor;
    }


}
