package com.umair.datastructures.array;


public class PrefixSum {
    public static void main(String[] args) {

        int length = 5;

        int noOfUpdates = 3;

        int[][] queries = new int[noOfUpdates][3];

        queries[0][0] = 1;
        queries[0][1] = 3;
        queries[0][2] = 2;

        queries[1][0] = 2;
        queries[1][1] = 4;
        queries[1][2] = 3;

        queries[2][0] = 0;
        queries[2][1] = 2;
        queries[2][2] = -2;


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static int[] getModifiedArray(int length, int[][] queries) {

            int[] res = new int[length];

            for(int i=0;i<queries.length;i++){
                int start = queries[i][0];
                int end = queries[i][1];
                int inc = queries[i][2];
                res[start]+=inc;
                if(end+1<length){
                    res[end+1]-=inc;
                }
            }

            int sum =0;
            for(int j=0;j<length;j++){
                sum+=res[j];
                res[j]=sum;
            }

            return res;
        }
    }

