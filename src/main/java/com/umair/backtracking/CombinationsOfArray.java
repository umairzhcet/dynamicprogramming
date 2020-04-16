package com.umair.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationsOfArray {

    public static void main(String[] args) {
        int[] array={3,2,5,8};
        Set partial=new HashSet<Integer>();
        int k=3;
       // combinations(array,k,partial,0);
        combinationsAlternative(array,k,partial,0);
    }

    private static void combinations(int[] array, int k,Set<Integer> partial, int index) {

        if(partial.size()==k){
            System.out.println(partial);
            return;
        }
        if(index==array.length){
            return;
        }
        for(int i=index;i<array.length;i++){
            partial.add(array[i]);
            combinations(array,k,partial,i+1);
            partial.remove(array[i]);

        }
    }

    private static void combinationsAlternative(int[] array, int k,Set<Integer> partial, int index) {

        if(partial.size()==k){
            System.out.println(partial);
            return;
        }
        if(index==array.length){
            return;
        }
        partial.add(array[index]);
        combinationsAlternative(array,k,partial,index+1);
        partial.remove(array[index]);
        combinationsAlternative(array,k,partial,index+1);

    }

}
