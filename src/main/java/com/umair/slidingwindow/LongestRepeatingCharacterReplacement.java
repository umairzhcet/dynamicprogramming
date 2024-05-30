package com.umair.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement main = new LongestRepeatingCharacterReplacement();
        String s ="AABABBA";
        int k=1;

        System.out.println(main.characterReplacement(s,k));

    }

    public int characterReplacement(String s, int k) {


        int[] freq=new int[26];
        int maxFreq =0;
        int i=0;
        int result =0;

        for(int j=0;j<s.length();j++){

            freq[s.charAt(j)-'A']++;
            maxFreq =Math.max(maxFreq, freq[s.charAt(j)-'A']);

            if(j-i+1-maxFreq>k){
                freq[s.charAt(i)-'A']--;
                i++;

            }
            result =Math.max(result,j-i+1);

        }

        return result;

    }
}
