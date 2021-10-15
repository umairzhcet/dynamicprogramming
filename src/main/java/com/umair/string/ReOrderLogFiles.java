package com.umair.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReOrderLogFiles {

    public static void main(String[] args) {
        ReOrderLogFiles main=new ReOrderLogFiles();
        String[] logs={"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        Arrays.stream(main.reorderLogFiles(logs)).forEach(System.out::println);
    }

    public String[] reorderLogFiles(String[] logs) {
        String[] result=new String[logs.length];
        List<String> digits=new ArrayList<>();
        List<String> words=new ArrayList<>();
        for(String str: logs){
            String[] s=str.split("\\s+");
            if(Character.isDigit(s[1].charAt(0))){
                digits.add(str);
            }
            else{
                words.add(str);
            }
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String a1=a.split("\\s+",2)[1];
                String b1=b.split("\\s+",2)[1];
                if (a1.equals(b1)) {
                    return a.split("\\s+",2)[0].compareTo(b.split("\\s+",2)[0]);
                }
                else {
                    return a1.compareTo(b1);
                }
            }
        });

        int i=0;
        for(String word:words){
            result[i++]=word;
        }
        for(String digit:digits){
            result[i++]=digit;
        }

        return result;

    }
}
