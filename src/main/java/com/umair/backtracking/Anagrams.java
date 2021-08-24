package com.umair.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        String str="god";
        char[] inputArray=str.toCharArray();
        Arrays.sort(inputArray);
        List partial=new ArrayList<String>();
        boolean[] isUsed=new boolean[str.length()];
        //permutations(inputArray,partial,isUsed);
        permutations("",str);
    }

    private static void permutations(char[] inputArray, List partial, boolean[] isUsed) {

        if(partial.size()==inputArray.length){
            System.out.println(partial);
        }

        for(int i=0;i<inputArray.length;i++){
            if(!isUsed[i] && !(i>0 && inputArray[i]==inputArray[i-1] && !isUsed[i-1])){
                isUsed[i]=true;
                partial.add(inputArray[i]);
                permutations(inputArray,partial,isUsed);
                isUsed[i]=false;
                partial.remove(partial.size()-1);
            }
        }
    }

    private static void permutations(String original, String remaining){

        if(remaining.length()==0){
            System.out.println(original);
        }

        for(int i=0;i<remaining.length();i++){
            String newOriginal=original+remaining.charAt(i);
            String newRemaining=remaining.substring(0,i)+remaining.substring(i+1);
            permutations(newOriginal,newRemaining);
        }

    }

}
