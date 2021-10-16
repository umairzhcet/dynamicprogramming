package com.umair.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray main=new ContiguousArray();
        System.out.println(main.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }

    public int findMaxLength(int[] nums) {

        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                sum=sum-1;
            else
                sum=sum+1;

            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }

        return result;

    }
}
