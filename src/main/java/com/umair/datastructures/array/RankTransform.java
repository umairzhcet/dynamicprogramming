package com.umair.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransform {
    public static void main(String[] args) {
         RankTransform main=new RankTransform();
         Arrays.stream(main.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})).forEach(System.out::println);
    }
    public int[] arrayRankTransform(int[] arr) {
        int[] nums=arr.clone();
        Arrays.sort(nums);
        int rank=1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
