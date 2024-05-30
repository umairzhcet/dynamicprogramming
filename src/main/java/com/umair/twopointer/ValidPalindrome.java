package com.umair.twopointer;

public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));

    }

    public boolean isPalindrome(String s) {


        int i=0;
        int j=s.length()-1;

        while(i<=j){
            char first = s.charAt(i);
            char last = s.charAt(j);

            if(!Character.isLetterOrDigit(first)){
                i++;
            }
            else if(!Character.isLetterOrDigit(last)){
                j--;
            }
            else{
                if(Character.toLowerCase(first)!=Character.toLowerCase(last)){
                    return false;
                }
                i++;
                j--;

            }


        }

        return true;

    }
}
