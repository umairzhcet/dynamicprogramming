package com.umair;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {

        int[] arr ={1,2,3,4,4,5,8};
        int target =4;
        
        List<Integer> list = findIndex(arr,0,target);
        System.out.println(list);

    }

    private static List<Integer> findIndex(int[] arr, int i, int target) {

        List<Integer> list = new ArrayList<>();

        if(i==arr.length) {
            return list;
            
        }
        if(arr[i]==target){
            list.add(i);
        }
        List<Integer> down=findIndex(arr,i+1,target);
        list.addAll(down);

        return list;
    }
}
