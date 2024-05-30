package com.umair.datastructures.array;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        int[] result =new TopKFrequentElements().topKFrequent(nums,k);

        for(int n:result){
            System.out.println(n);
        }
    }

    //O(N) complexity
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freqMap= new HashMap<>();

        for(int n: nums){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }

        //bucket sort

        List<Integer> bucket[] = new ArrayList[nums.length+1];

        for(Integer key: freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] result = new int[k];
        int index =0;

        for(int i=bucket.length-1;i>=1;i--)   {
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    result[index++]=num;
                    if(index==k){
                        return result;
                    }
                }

            }
        }

        return result;
    }

    //O(NLogK) complexity
    public int[] topKFrequent2(int[] nums, int k) {

        int[] result=new int[k];

        if(nums.length==0){
            return result;
        }

        Map<Integer,Integer> map=new HashMap<>();



        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new KeyComparator());

        for (Map.Entry<Integer,Integer> entry : map.entrySet())  {
            int key=entry.getKey();
            int frequency=entry.getValue();
            Pair p=new Pair(frequency,key) ;
            pq.add(p);

            if(pq.size()>k){
                pq.poll();
            }

        }
        int i=0;
        while(!pq.isEmpty()){
            result[i++]=pq.poll().value;
        }


        return result;
    }

    class Pair {

        int key;
        int value;

        public Pair(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    class KeyComparator implements Comparator<Pair>{

        public int compare(Pair s1, Pair s2) {
            return Integer.compare(s1.key,s2.key);


        }
    }


}
