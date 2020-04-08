package com.umair.recursion;

public class isPalindrome {
    public static void main(String[] args) {
        String s="abcba";
        boolean result=isPalindrome(s,0,s.length()-1);
        System.out.println(result);

    }

    private static boolean isPalindrome(String s,int i,int j){
        if(i>=j){
            return true;
        }
        return s.charAt(i)==s.charAt(j) && isPalindrome(s,i+1,j-1);
    }
}
