package com.umair.backtracking;

import java.util.*;

public class DictionaryWords {

    public static void main(String[] args) {

        Set dict=new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        String input="catsanddog";
        List partial=new ArrayList<String>();
        wordBreak(input,dict,partial);
    }

    private static void wordBreak(String input, Set dict, List partial) {
        if(input.length()==0){
            System.out.println(Arrays.toString(partial.toArray()));
            return;
        }
        for(int i=0;i<input.length();i++){

            String word=input.substring(0,i+1);
            if(dict.contains(word)){
                partial.add(word);
                wordBreak(input.substring(i+1),dict,partial);
                partial.remove(partial.size()-1);
            }



        }
    }
}
