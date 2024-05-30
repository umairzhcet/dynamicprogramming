package com.umair.datastructures.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}  ;

        System.out.println(new ValidSudoku().isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char val =board[i][j];
                if(val!='.'){
                    if(!set.add(val +"found in row"+i) ||
                            !set.add(val +"found in column"+j) ||
                            !set.add(val +"found in board"+i/3+'-'+j/3)){
                        System.out.println(val+":already present"+i+"-"+j);
                        return false;
                    }
                }
            }
        }

        return true;

    }
}
