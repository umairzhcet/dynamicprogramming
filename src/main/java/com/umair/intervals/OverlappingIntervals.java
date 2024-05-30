package com.umair.intervals;

import java.util.*;

public class OverlappingIntervals {

    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] output =new OverlappingIntervals().merge(intervals);
        Arrays.stream(output).forEach(arr-> System.out.println(arr[0]+" "+arr[1]));

    }

    public int[][] merge(int[][] intervalsArray){

        if(intervalsArray.length<2){
            return intervalsArray;
        }
        List<Interval> intervals = new ArrayList<>();
        for(int[] interval :intervalsArray){
            intervals.add(new Interval(interval[0],interval[1]));
        }

        intervals.sort(Comparator.comparingInt(in->in.start));
        List<Interval> result = new LinkedList<>();
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        for(int i=1;i<intervals.size();i++){
            Interval current = intervals.get(i);
            if(current.start<=end){
                end = Math.max(end, current.end);
            }
            else{
                result.add(new Interval(start,end));
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start,end));

        int[][] resultArray = new int[result.size()][2];
        int j=0;
        for(Interval in: result){
            resultArray[j][0] =in.start;
            resultArray[j][1] =in.end;
            j++;
        }

        return resultArray;

    }


    private class Interval{
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
