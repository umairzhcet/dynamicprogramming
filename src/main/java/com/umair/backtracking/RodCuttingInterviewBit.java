package com.umair.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCuttingInterviewBit {

    public static void main(String[] args) {
        Integer[] array={1,2,5};
        ArrayList<Integer> rod= new ArrayList<>(Arrays.asList(array));

        int N=6;

        ArrayList<Integer> result=new ArrayList<>();

        boolean[] isUsed=new boolean[rod.size()];
        List partial=new ArrayList<Integer>();
        Integer min=Integer.MAX_VALUE;
        permutations(N,rod,partial,isUsed,result,min);
        System.out.println(result);
    }

    public static void permutations(int N, List<Integer> array, List<Integer> partial, boolean[] isUsed, List<Integer> result,Integer min) {


        if(partial.size()==array.size()){
            int sum=0;
            int temp=N;
            int l1=0;
            int l2=temp;
            for(int i=0;i<partial.size();i++){
                if(partial.get(i)<=l1){
                    sum+=l1;
                    l1=l1-partial.get(i);

                }
                else{
                    sum+=l2;
                    int c=l2;
                    l2=l2-(partial.get(i)-l1);
                    if(c-l2>l2){
                        l1=c-l2;
                    }

                }

            }
            if(sum<min){
                min=sum;
                //result.clear();
                result.addAll(partial);
                result.add(sum);
            }
            return;
        }
        for(int i=0;i<array.size();i++){
            if(!isUsed[i]){
                partial.add(array.get(i));
                isUsed[i]=true;
                permutations(N,array,partial,isUsed,result,min);
                partial.remove(partial.size()-1);
                isUsed[i]=false;
            }
        }
    }

}
