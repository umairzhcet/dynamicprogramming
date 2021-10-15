package com.umair.datastructures.array;

import java.util.ArrayList;
import java.util.List;

public class MaximumUnitsOnTruck {

    public static void main(String[] args) {

        MaximumUnitsOnTruck main=new MaximumUnitsOnTruck();
        int[][] boxTypes={{5,10},{2,5},{4,7},{3,9}};
        int truckSize=10;
        System.out.println(main.maximumUnits(boxTypes,truckSize));

    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        List<Box> list=new ArrayList<>();

        for(int[] box:boxTypes){
            list.add(new Box(box[0],box[1]));
        }
        list.sort((a,b)->Integer.compare(b.numberOfBoxUnits,a.numberOfBoxUnits));

        int max=0;
        int boxes=0;

        for(Box b:list){
            if(boxes==truckSize){
                break;
            }
            if(boxes+b.numberOfBoxes<=truckSize){
                boxes+=b.numberOfBoxes;
                max+=b.numberOfBoxes * b.numberOfBoxUnits;
            }
            else{
                max+=(truckSize-boxes)*b.numberOfBoxUnits;
                break;
            }
        }

        return max;
    }

    class Box{
        int numberOfBoxes;
        int numberOfBoxUnits;

        public Box(int boxes, int units){
            this.numberOfBoxes=boxes;
            this.numberOfBoxUnits=units;
        }
    }
}
