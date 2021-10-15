package com.umair.datastructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StockPrediction {

    public static void main(String[] args) {

        List<Integer> stockData=new ArrayList<>();
        Integer[] stocks={
                89214,
                26671,
                75144,
                32445,
                13656,
                66289,
                21951,
                10265,
                59857,
                59133,
                63227,
                86121,
                37411,
                54628,
                25859,
                43510,
                63756,
                54763,
                30852,
                53243,
                76238,
                96885,
                33074,
                17745,
                81814,
                43436,
                79172,
                92819,
                30001,
                68442,
                54021,
                35566,
                95113,
                29164,
                84362,
                25120,
                11804,
                6313,
                51736,
                71661,
                81797,
                14962,
                57781,
                35560,
                85941,
                99991,
                95421,
                66048,
                54754,
                26272,
                35642,
                47343,
                39508,
                85068,
                65087,
                21321,
                28503,
                60611,
                30491,
                58503,
                29052,
                84512,
                94069,
                40516,
                13675,
                78430,
                65635,
                25479,
                1094,
                17370,
                13491,
                99243,
                48683,
                71271,
                34802,
                34624,
                87613,
                46574,
                671,
                42366,
                89197,
                36313,
                89708,
                28704,
                21380,
                54795,
                66376,
                49882,
                15405,
                96867,
                24737,
                60808,
                81378,
                35157,
                1324,
                11404,
                29938,
                66958,
                53234,
                47384
        };

        stockData.addAll(Arrays.asList(stocks));

        Integer[] data={
                80,
                24,
                26,
                62,
                46,
                79,
                85,
                59,
                52,
                8,
                76,
                48,
                72,
                84,
                3,
                3,
                30,
                30,
                36,
                86,
                96,
                72,
                93,
                25,
                28,
                68,
                81,
                18,
                78,
                14,
                1,
                57,
                90,
                26,
                18,
                87,
                56,
                55,
                97,
                59,
                62,
                73,
                58,
                85,
                8,
                60,
                87,
                89,
                89,
                22
        };
        List<Integer> queries=Arrays.asList(data);

        List<Integer> result=predictAnswer(stockData,queries);
        System.out.println(result);

    }

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {

        List<Integer> result=new ArrayList<>();

        int[] leftSmaller=new int[stockData.size()];
        int[] rightSmaller=new int[stockData.size()];

        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<stockData.size();i++){
            if(stack.isEmpty()){
                leftSmaller[i]=-1;
            }
            else if(stack.peek()[0]<stockData.get(i)){
                leftSmaller[i]=stack.peek()[1];
            }
            else if(stack.peek()[0]>=stockData.get(i)){
                while(!stack.isEmpty() && stack.peek()[0]>=stockData.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    leftSmaller[i]=-1;
                }
                else{
                    leftSmaller[i]=stack.peek()[1];
                }
            }
            stack.push(new int[]{stockData.get(i),i+1});
        }
        stack=new Stack<>();

        for(int i=stockData.size()-1;i>=0;i--){
            if(stack.isEmpty()){
                rightSmaller[i]=-1;
            }
            else if(stack.peek()[0]<stockData.get(i)){
                rightSmaller[i]=stack.peek()[1];
            }
            else if(stack.peek()[0]>=stockData.get(i)){
                while(!stack.isEmpty() && stack.peek()[0]>=stockData.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    rightSmaller[i]=-1;
                }
                else{
                    rightSmaller[i]=stack.peek()[1];
                }
            }
            stack.push(new int[]{stockData.get(i),i+1});
        }
        Collections.reverse(Arrays.asList(rightSmaller));

//        for(int i=0;i<leftSmaller.length;i++)
//            System.out.print(leftSmaller[i]+" ");
//        System.out.println();
//        for(int i=0;i<rightSmaller.length;i++)
//            System.out.print(rightSmaller[i]+" ");

        for(int i=0;i<queries.size();i++){
            int index=queries.get(i)-1;
            if(leftSmaller[index]!=-1){
                if(rightSmaller[index]!=-1){
                    result.add(Math.min(leftSmaller[index],rightSmaller[index]));
                }

            }
            else{
                result.add(rightSmaller[index]);
            }
        }

        return result;

    }
}
