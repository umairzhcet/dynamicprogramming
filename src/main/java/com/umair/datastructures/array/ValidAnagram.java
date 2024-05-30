package com.umair.datastructures.array;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(new ValidAnagram().isAnagram(s,t));

    }

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int n:arr){
            if(n!=0){
                return false;
            }
        }

        return true;


    }


}
