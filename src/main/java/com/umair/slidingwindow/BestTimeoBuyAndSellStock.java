package com.umair.slidingwindow;

public class BestTimeoBuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeoBuyAndSellStock().maxProfit2(prices));

    }

    public int maxProfit(int[] prices) {

        int i =0;
        int j =1;
        int profit =0;

        while(j<prices.length){
            if(prices[i]<prices[j]){
                profit =Math.max(profit,prices[j]-prices[i]);
                j++;
            }
            else{
                i =j;
                j++;
            }

        }

        return profit;
    }

    public int maxProfit2(int[] prices) {

        int minSoFar =prices[0];
        int profit =0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]<minSoFar){
                minSoFar=prices[i];
            }
            else{
                profit =Math.max(profit,prices[i]-minSoFar);
            }
        }

        return profit;
    }
}
