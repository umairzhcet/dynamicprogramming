package com.umair.datastructures.array;

public class FruitsIntoBaskets {

    public static void main(String[] args) {
        int[] tree={0,1,6,6,4,4,6};
        System.out.println(totalFruit(tree));

    }

    public static int totalFruit(int[] tree) {

        if(tree==null || tree.length==0){
            return 0;
        }
        int lastFruit=-1;
        int secondLastFruit=-1;
        int lastFruitCount=0;
        int currentMax=0;
        int result=0;

        for(int fruit:tree){

            if(fruit==lastFruit || fruit==secondLastFruit){
                currentMax++;
            }
            else{
                currentMax=lastFruitCount+1;
            }
            if(fruit!=lastFruit){

                secondLastFruit=lastFruit;
                lastFruit=fruit;
                lastFruitCount=1;
            }
            else{
                lastFruitCount++;
            }

            result=Math.max(result,currentMax);
        }

        return result;
    }
}
