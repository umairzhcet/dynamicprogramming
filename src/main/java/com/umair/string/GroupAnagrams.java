package com.umair.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        for(String input:strs){
            char[] charArray=input.toCharArray();
            Arrays.sort(charArray);
            String sorted=new String(charArray);



            if(map.containsKey(sorted)){
                list=map.get(sorted);
            }
            else{
                list=new ArrayList<>();
            }
            list.add(input);
            map.put(sorted,list);

        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        System.out.println(result);

    }
}
