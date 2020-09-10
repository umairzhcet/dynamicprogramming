package com.umair.recursion;

import java.util.HashSet;

public class StringPermutations {

    public static void main(String[] args) {
        String s1="ab";
         String s2="dbao";

        HashSet<String> result=new HashSet<String>();

        permute(s2,0,s2.length()-1,result);
        System.out.println(result);
        for(String str:result){
            if(str.contains(s1)){
                System.out.println("true");
            }
        }
        System.out.println("false");

    }

    public static void permute(String string, int start, int end, HashSet<String> result){

        if(start==end){
            result.add(string);
        }

        for(int i=start;i<=end;i++){
            String swapped=swap(string,start,i);
            permute(swapped,start+1,end,result);

        }
    }

    public static String swap(String string,int left,int right){

        char[] array=string.toCharArray();
        char temp=array[left];
        array[left]=array[right];
        array[right]=temp;

        return String.valueOf(array);

    }
}
