package com.umair.backtracking;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] array={10,1,2,7,6,1,5};
        Arrays.sort(array);
        int target=8;
        List partial=new ArrayList<Integer>();
        combinations(array,target,partial,0,0);

    }

    private static void combinations(int[] array, int target, List<Integer> partial,int sum,int index) {

        if(sum==target){
            System.out.println(partial);
        }
        if(index==array.length){
            return;
        }

        for(int i=index;i<array.length;i++){
            int temp=array[i];
            if(sum+temp>target || (i>index && array[i]==array[i-1])){
                continue;
            }
            partial.add(temp);
            combinations(array,target,partial,sum+temp,i+1);
            partial.remove(partial.size()-1);

        }
    }
}
