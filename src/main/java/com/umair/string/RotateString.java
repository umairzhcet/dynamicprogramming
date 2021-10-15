package com.umair.string;

public class RotateString {

    public static void main(String[] args) {

        String s="abcde";
        String goal="bcdea";
        char g = goal.charAt(0);
        int len  = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != g) continue;

            String suffix = s.substring(i);
            String prefix = s.substring(0, i);

            if (goal.equals(suffix + prefix)) System.out.println(true);
        }

        System.out.println(false);
    }
}
