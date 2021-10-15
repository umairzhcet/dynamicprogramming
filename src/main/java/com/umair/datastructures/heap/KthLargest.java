package com.umair.datastructures.heap;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public static void main(String[] args) {

        int k=3;
        int[] nums={4,5,8,2};
        KthLargest main=new KthLargest(k,nums);
        System.out.println(main.add(3));
        System.out.println(main.add(5));
        System.out.println(main.add(10));
        System.out.println(main.add(9));
        System.out.println(main.add(4));

    }

    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();

        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }

    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k)
            pq.poll();

        return pq.peek();

    }

}
