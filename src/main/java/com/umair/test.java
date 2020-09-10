package com.umair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class test {


    public static void main(String[] args) {

        int[] arr={2,50,40,10,20};
        for(int i=0;i<arr.length;);

        Queue<Pair> q=new PriorityQueue<>(5,new PairComparator());

        //meetup schedule

//        Investor class
//                id
//                start
//                end
//
//priorityQueue based on end day
//        hashmap of meeting day
//        loop queue and check for all available days

    }

    class Pair{
        int distance;
        int[][] coordinates;

        public Pair(int distance,int[][] coordinates){
            this.distance=distance;
            this.coordinates=coordinates;
        }

    }

    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2){

            return Integer.compare(p1.distance,p2.distance);
        }

    }
}





