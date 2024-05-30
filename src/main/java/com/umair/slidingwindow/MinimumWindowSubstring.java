package com.umair.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        System.out.println(new MinimumWindowSubstring().minWindow2("ADOBECODEBANC","ABC"));


    }


    public String minWindow(String s, String t) {

        int i=0;
        String result="";

        Map<Character, Integer> map = new HashMap<>();
        for(int k=0;k<t.length();k++){
            map.put(t.charAt(k),map.getOrDefault(t.charAt(k),0)+1);
        }

        int count =map.size();
        int min=Integer.MAX_VALUE;


        for(int j=0;j<s.length();j++){
            char c =s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    count--;
                }
            }
            if(count>0)continue;

            while(count==0){
                char a = s.charAt(i++);
                if(map.containsKey(a)){
                    map.put(a,map.get(a)+1);
                    if(map.get(a)>0){
                        count++;
                    }
                }

            }
            if(min>(j-i)){
                min =j-i+1;
                result=s.substring(i-1,j+1);

            }

        }

        return result;

    }


    //better performance as instead of map we use array
    public String minWindow2(String s, String t) {

        int i=0;
        String result="";

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for(int k=0;k<t.length();k++){
           arr1[t.charAt(k)]++;
        }

        int count =0;
        int min=Integer.MAX_VALUE;


        for(int j=0;j<s.length();j++){

            arr2[s.charAt(j)]++;
            char c =s.charAt(j);
            if(arr2[c]<=arr1[c]){
               count++;
            }

            if(count<t.length()) continue;

            if(count==t.length()){
                while(arr2[s.charAt(i)]>arr1[s.charAt(i)] || arr1[s.charAt(i)]==0 ){
                    arr2[s.charAt(i)]--;
                    i++;
                }
            }

            if(min>(j-i+1)){
                min =j-i+1;
                result=s.substring(i,j+1);

            }

        }

        return result;

    }

}
