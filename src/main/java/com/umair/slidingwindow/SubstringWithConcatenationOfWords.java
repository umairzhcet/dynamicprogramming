package com.umair.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfWords {

    public static void main(String[] args) {

        String s="barfoothefoobarman";
        String[] words={"foo","bar"};

        String s1="wordgoodgoodgoodbestword";
        String[] words1={"word","good","best","good"};

        System.out.println(new SubstringWithConcatenationOfWords().findSubstring(s1,words1));

    }

    public List<Integer> findSubstring(String s, String[] words) {

        int len =words.length*words[0].length();
        Map<String,Integer> wordMap=new HashMap<>();
        for(String w:words){
            wordMap.put(w,wordMap.getOrDefault(w,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=s.length()-len;i++){

            String str=s.substring(i,i+len);
            if(containsWord(str,wordMap,words[0].length())){
                result.add(i);
            }

        }


        return result;
    }

    public boolean containsWord(String str, Map<String, Integer> words, int count){

        Map<String,Integer> substringMap=new HashMap<>();

        for(int i=0;i<str.length();i+=count){
            String w =str.substring(i,i+count);
            substringMap.put(w,substringMap.getOrDefault(w,0)+1);
            if(substringMap.get(w)>words.getOrDefault(w,0)){
                return false;
            }
        }
        return true;

    }

}
