package com.umair.datastructures.heap;

import java.util.*;

public class KClosestElements {

    public static void main(String[] args) {

        KClosestElements main=new KClosestElements();
        main.findClosestElements(new int[]{1,2,3,4,5},4,3).stream().forEach(System.out::println);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(Math.abs(a-x)==Math.abs(b-x)){
                    return Integer.compare(a,b);
                }
                else{
                    return Integer.compare(Math.abs(a-x),Math.abs(b-x));
                }

            }

        });

        for(int i:arr)
            pq.offer(i);

        List<Integer> result=new ArrayList<>();
        int i=0;
        while(i<k){
            result.add(pq.poll());
            i++;
        }
        Collections.sort(result);
        return result;
    }
}
