package com.umair.string;

public class FindDifference {
    public static void main(String[] args) {
        FindDifference main=new FindDifference();
        System.out.println(main.findTheDifference("ae","aea"));
        System.out.println(main.findTheDifference("abcd","abcde"));
    }
    public char findTheDifference(String s, String t) {

        int[] count=new int[26];

        for(char c:t.toCharArray()){
            count[c-'a']++;
        }

        for(char c:s.toCharArray()){
            count[c-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return (char)(i+97);
            }
        }

        return 'a';
    }
}
