package com.umair.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        ArrayList<Integer> nums=new ArrayList<>();
        Integer[] arr={1,5,2,9,7};
        nums.addAll(Arrays.asList(arr));
        sort(nums);
        System.out.println(nums);
    }

    private static void sort(ArrayList<Integer> nums) {

        if(nums.size()==1){
            return;
        }
        int temp=nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        sort(nums);
        insert(nums,temp);
    }

    private static void insert(ArrayList<Integer> nums, int temp) {
        if(nums.size()==0 || nums.get(nums.size()-1)<=temp){
            nums.add(temp);
            return;
        }
        int item=nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        insert(nums,temp);
        nums.add(item);

    }
}
