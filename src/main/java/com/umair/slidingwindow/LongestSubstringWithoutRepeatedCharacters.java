package com.umair.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {

    public static void main(String[] args) {

        System.out.println(new LongestSubstringWithoutRepeatedCharacters().lengthOfLongestSubstring("bbbbb"));

    }

    public int lengthOfLongestSubstring(String s) {

        int i =0;
        int j =0;

        Set<Character> set = new HashSet<>();

        int result =0;

        while(j<s.length()){
            if(set.contains(s.charAt(j))){
               while(s.charAt(i)!=s.charAt(j)){
                   set.remove(s.charAt(i++));
               }
               set.remove(s.charAt(i++));
            }
            else{
                set.add(s.charAt(j));
                result = Math.max(result, set.size());
                j++;

            }

        }

        return result;

    }


    //best performance
    public int lengthOfLongestSubstring2(String s) {

        int res=0;
        int arr[]=new int[128];
        int i=0;
        for(int j=0;j<s.length();j++){
            arr[s.charAt(j)]++;
            while(arr[s.charAt(j)]>1){
                arr[s.charAt(i)]--;
                i++;
            }
            res=Math.max(res,j-i+1);


        }
        return res;
    }
}
