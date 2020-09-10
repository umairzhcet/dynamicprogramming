package com.umair.backtracking;

import java.util.Arrays;

public class NQueensProblem {

    public static void main(String[] args) {

            int numOfQueens=8;
            int[][] chessTable = new int[numOfQueens][numOfQueens];

            boolean result=setQueens(chessTable,0);
            System.out.println(result);
            for(int i=0;i<chessTable.length;i++){
                for(int j=0;j<chessTable.length;j++){
                    System.out.print(chessTable[i][j]+" ");
                }
                System.out.println();
            }




    }

    private static boolean setQueens(int[][] chessTable, int colIndex) {

        if(colIndex==chessTable.length)
            return true;
        for(int rowindex=0;rowindex<chessTable.length;rowindex++){
            if(isValid(chessTable,rowindex,colIndex)){

                chessTable[rowindex][colIndex]=1;
                if(setQueens(chessTable,colIndex+1)){
                    return true;
                }
                else{
                    chessTable[rowindex][colIndex]=0;
                }
            }

        }
        return false;
    }

    private static boolean isValid(int[][] chessTable, int rowIndex, int colIndex) {

        //check if row already has a queen
        for(int i=0;i<colIndex;i++){
            if(chessTable[rowIndex][i]==1){
                return false;
            }
        }

        //check for top left and bottom right diagonal
        for(int i=rowIndex,j=colIndex;i>=0 && j>=0;i--,j--){
            if(chessTable[i][j]==1){
                return false;
            }
        }

        //check for top right and bottom left diagonal
        for(int i=rowIndex,j=colIndex;i<chessTable.length && j>=0;i++,j--){
            if(chessTable[i][j]==1){
                return false;
            }
        }

        return true;
    }
}
