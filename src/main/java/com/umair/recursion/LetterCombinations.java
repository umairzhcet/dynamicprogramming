package com.umair.recursion;

import java.util.*;

public class LetterCombinations {
    static Map<Integer,List<Character>> map = new HashMap<>();


    public static void main(String[] args) {


        List<String> result = letterCombinations("23");
        System.out.println(result);

    }

    static public List<String> letterCombinations(String digits) {

        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m','n','o'));
        map.put(7, Arrays.asList('p','q','r','s'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));

        return helper(digits,"");

    }

    static List<String> helper(String p, String up){

        List<String> result = new ArrayList<>();

        if(p.length()==0){
            if(!up.equals(""))
            result.add(up);
            return result;
        }
        List<Character> combs =map.get(p.charAt(0)-'0');

        for(int i=0;i<combs.size();i++){
            String add =Character.toString(combs.get(i));
            result.addAll(helper(p.substring(1),up+add));
        }

        return result;
    }
}
