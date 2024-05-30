package com.umair.slidingwindow;

public class PermutationInString {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(new PermutationInString().checkInclusion(s1,s2));

    }

    public boolean checkInclusion(String s1, String s2) {


        int[] arr1=new int[26];
        int[] arr2=new int[26];
        int i=0;

        for(int a=0;a<s1.length();a++){
            arr1[s1.charAt(a)-'a']++;
        }

        for(int j=0;j<s2.length();j++){

            arr2[s2.charAt(j)-'a']++;
            if(j-i+1==s1.length()){
                if(match(arr1,arr2)){
                    return true;
                }
                else{
                    arr2[s2.charAt(i)-'a']--;
                    i++;
                }
            }

        }

        return false;

    }

    private boolean match(int[] arr1, int[] arr2){

        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }

        return true;
    }
}
