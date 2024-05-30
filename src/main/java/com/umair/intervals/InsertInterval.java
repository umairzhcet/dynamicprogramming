package com.umair.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        // given intervals are mutually exclusive and sorted on start time
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] output =new InsertInterval().insert(intervals, newInterval);
        Arrays.stream(output).forEach(arr-> System.out.println(arr[0]+" "+arr[1]));

    }

    private int[][] insert(int[][] intervals, int[] newInterval) {

        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval :intervals){
            intervalList.add(new Interval(interval[0],interval[1]));
        }

        Interval intervalToAdd = new Interval(newInterval[0],newInterval[1]);

        List<Interval> result = new ArrayList<>();

        // first add intervals to the left of the interval to be inserted
        int i=0;
        while(i<intervalList.size() && intervalList.get(i).end<intervalToAdd.start){
            result.add(intervalList.get(i));
            i++;
        }

        //add overlapping intervals
        while(i<intervalList.size() && intervalList.get(i).start <= intervalToAdd.end){
            intervalToAdd.start=Math.min(intervalToAdd.start,intervalList.get(i).start);
            intervalToAdd.end=Math.max(intervalToAdd.end,intervalList.get(i).end);
            i++;
        }
        result.add(new Interval(intervalToAdd.start,intervalToAdd.end));

        // add intervals to the right of new interval

        while(i<intervalList.size()){
            result.add(intervalList.get(i));
            i++;
        }

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
