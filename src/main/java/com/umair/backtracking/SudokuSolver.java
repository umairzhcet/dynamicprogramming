package com.umair.backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
       SudokuSolver main = new SudokuSolver();
       char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
       System.out.println(main.helper(board,0,0));
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public boolean helper(char[][] board, int r, int c) {

        if(r==board.length){
            return true;
        }

        int nr=0;
        int nc=0;

        if(c!=board.length-1){
            nc=c+1;
            nr=r;
        }
        else{
            nc=0;
            nr=r+1;
        }

        if(board[r][c]!='.'){
            if(helper(board,nr,nc)){
                return true;
            }
        }
        else{
            for(int i=1;i<=9;i++){
                if(isValid(board,r,c,i)){
                    board[r][c]=(char)(i+'0');
                    if(helper(board,nr,nc)){
                        return true;
                    }
                    else{
                        board[r][c]='.';
                    }
                }
            }
        }

        return false;

    }

    public boolean isValid(char board[][], int r, int c, int d){

        for(int i=0;i<board.length;i++){
            if(board[r][c]==(char)(d+'0')){
                return false;
            }
            if(board[r][c]==(char)(d+'0')){
                return false;
            }
            int sr =(r/3)*3+ i/3;
            int sc =(c/3)*3+ i%3;
            if (board[r][c] == (char)(d+'0')) {
                return false;
            }
        }
        return true;
    }
}
