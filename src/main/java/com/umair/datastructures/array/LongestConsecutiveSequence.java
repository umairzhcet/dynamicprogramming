package com.umair.datastructures.array;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        LongestConsecutiveSequence main=new LongestConsecutiveSequence();
        System.out.println(main.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        Set<Integer> set=new TreeSet<>();

        for(int i:nums){
            set.add(i);
        }
        int len=1;
        int max=1;
        for(int num:set){

            if(set.contains(num-1)){
                len++;
            }
            else{
                len=1;
            }
            max=Math.max(max,len);
        }

        return max;
    }

}
