package com.umair.dynamicprogramming.leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubStringCharacterCount {
    static Set<String> set;
    public static void main(String[] args) {
      DistinctSubStringCharacterCount main=new DistinctSubStringCharacterCount();
      set=new HashSet<>();
      main.subStrings("test");
        System.out.println(set);
        int count=0;
        for(String str:set){
            //count+=str.chars().distinct().count();
            Set<Character> temp = new HashSet<Character>();
            for (int i = 0; i < str.length(); i++) {
                temp.add(str.charAt(i));
            }
            count+=temp.size();
        }
        System.out.println(count);
    }

    public void subStrings(String str){

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                set.add(str.substring(i,j));
            }
        }
    }
}
