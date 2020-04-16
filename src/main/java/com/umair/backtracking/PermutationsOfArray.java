package com.umair.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArray {

    public static void main(String[] args) {
        int[] array={1,2,3,4};
        boolean[] isUsed=new boolean[array.length];
        List partial=new ArrayList<Integer>();
        permutations(array,partial,isUsed);
    }

    private static void permutations(int[] array, List<Integer> partial,boolean[] isUsed) {

        if(partial.size()==array.length){
            System.out.println(partial);
            return;
        }
        for(int i=0;i<array.length;i++){
            if(!isUsed[i]){
                partial.add(array[i]);
                isUsed[i]=true;
                permutations(array,partial,isUsed);
                partial.remove(partial.size()-1);
                isUsed[i]=false;
            }
        }
    }
}
