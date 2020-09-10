package com.umair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusStand {

    public static void main(String[] args) {
        int k=2;

        List<Integer> p = new ArrayList<>();
        p.add(1);
        p.add(4);
        p.add(4);
        p.add(3);
        p.add(1);
        p.add(2);
        p.add(6);

        List<Integer> q = new ArrayList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);

        List<Integer> result = new ArrayList<>();
        List<Pair> pairs=new ArrayList<>();
        for(int i=0;i<p.size();i++){
            Pair pair=new Pair(i+1,p.get(i));
            pairs.add(pair);
        }
        Collections.sort(pairs);


        for (int i = 0; i < q.size(); i++) {
            int index=indexOfNext(pairs,q.get(i));
            if(pairs.size()-index>=k){
                result.add(pairs.get(index+k-1).index);
            }
            else{
                result.add(0);
            }

        }

        System.out.println(result);
    }

    public static int indexOfNext(List<Pair> p, int item){
        int ceil=-1;
        int start=0;
        int end=p.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(p.get(mid).value==item){
                ceil=mid;
                end=mid-1;
            }
            else if(p.get(mid).value<item){
                start=mid+1;
            }
            else{
                ceil=mid;
                end=mid-1;
            }
        }
        return ceil;
    }

    static class Pair implements Comparable<Pair> {
        public final int index;
        public final int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.valueOf(this.value).compareTo(pair.value);
        }
    }
}
