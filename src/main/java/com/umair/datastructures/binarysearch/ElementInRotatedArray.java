package com.umair.datastructures.binarysearch;

public class ElementInRotatedArray {

    public static void main(String[] args) {
        int nums[]={5,1,3};
        int target=0;

        int start=0;
        int N=nums.length;
        int end=N-1;
        int minIndex=-1;
        int result=-1;

        while(start<=end){
            if(nums[start]<=nums[end]){
                minIndex=start;
                break;
            }

            int mid=start+(end-start)/2;
            int prev=(mid-1+N)%N;
            int next=(mid+1)%N;
            if(nums[mid]<nums[prev] && nums[mid]<nums[next]){
                minIndex=mid;
            }
            else if(nums[mid]>nums[end]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }

        System.out.println(minIndex);
        if(target==nums[minIndex]){
            result=minIndex;
        }
        if(target<=nums[N-1] && target>=nums[minIndex]){
            end=N-1;
            start=minIndex;

        }
        else{
            start=0;
            end=minIndex;
        }
        while(start<=end){
            int mid=start+(end-start)/2;

            if(target==nums[mid]){
                result=mid;
                break;
            }

            else if(target>nums[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }


        System.out.println(result);

    }
}
