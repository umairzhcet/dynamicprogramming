package com.umair.slidingwindow;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int[] nums2 = {-7,-8,7,5,7,1,6,0};
        int k1=3;
        int k2=4;
        int[] result =new SlidingWindowMaximum().maxSlidingWindow(nums2,k2);
        for(int n:result){
            System.out.print(n+" ");
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result=new int[nums.length-k+1];

        int i=0;
        Deque<Integer> dq = new ArrayDeque<>();

        for(int j=0;j<nums.length;j++){

            if(!dq.isEmpty() && dq.peekFirst()<(j-k+1)){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[j]){
                dq.pollLast();
            }
            dq.offer(j); // or offerLast
            if((j-i+1)%k==0){
                result[i++]=nums[dq.peekFirst()];
            }

        }

        return result;

    }
}
