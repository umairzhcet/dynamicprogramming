package com.umair.recursion;

public class MinimumDifficultyJobSchedule {

    int[][] cache;
    public static void main(String[] args) {

        MinimumDifficultyJobSchedule main=new MinimumDifficultyJobSchedule();

        int[] jobDifficulty = {11,111,22,222,33,333,44,444};
        int d=6;
        System.out.println(main.minDifficulty(jobDifficulty,d));
    }
    public int minDifficulty(int[] jobDifficulty, int d) {

        if(d>jobDifficulty.length){
            return -1;
        }
        cache = new int[d+1][jobDifficulty.length];
        return solve(0,jobDifficulty,d);

    }

    public int solve(int i,int[] jd,int d){

        if(d==1){
            int max=Integer.MIN_VALUE;
            for(int k=i;k<jd.length;k++)
                max=Math.max(max,jd[k]);
            return max;
        }
        if(cache[d][i]!=0){
            return cache[d][i];
        }
        int min=Integer.MAX_VALUE;
        int maxCurr=Integer.MIN_VALUE;
        for(int k=i;k<=jd.length-d;k++){
            maxCurr=Math.max(maxCurr,jd[k]);
            min=Math.min(min,maxCurr+solve(k+1,jd,d-1));
        }

        return cache[d][i]=min;
    }
}
