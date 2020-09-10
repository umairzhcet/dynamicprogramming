package com.umair.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> solution = new ArrayList<>();
    public static void main(String[] args) {

        int[] candidates={2,3,5};
        int target=8;

        recursiveSol(candidates,target,new ArrayList<Integer>(), 0);
        System.out.println(solution);

    }

    public static void recursiveSol(int[] input,int target,List<Integer> partial,int index){

        if(index==input.length){
            return;
        }
        if(target==0){
            if(!solution.contains(partial))
                solution.add(partial);
        }
        if(input[index]<=target){
            recursiveSol(input,target,new ArrayList<>(partial), index+1);
            partial.add(input[index]);
            recursiveSol(input,target-input[index],new ArrayList<>(partial), index);
        }
        else{
            recursiveSol(input,target,new ArrayList<>(partial), index+1);
        }


    }
}
