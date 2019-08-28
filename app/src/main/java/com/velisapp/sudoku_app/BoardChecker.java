package com.velisapp.sudoku_app;

import java.util.ArrayList;

public class BoardChecker {

    private int[][] board;
    private static final int BOARD_SIZE = 9;
    private static final int INNER_SQUARE_SIZE = 3;
    private static final int EMPTY = 0; // empty cell

    public static void main(String []args){

    }

    // we check if a number is already in a row
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < BOARD_SIZE; i++)
            if (board[row][i] == number)
                return true;

        return false;
    }

    // we check if a possible number is already in a column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < BOARD_SIZE; i++)
            if (board[i][col] == number)
                return true;

        return false;
    }

    // we check if a possible number is in its 3x3 square
    private boolean isInSquare(int row, int col, int number) {
        int r = row - row % INNER_SQUARE_SIZE;
        int c = col - col % INNER_SQUARE_SIZE;

        for (int i = r; i < r + INNER_SQUARE_SIZE; i++)
            for (int j = c; j < c + INNER_SQUARE_SIZE; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }


    private boolean checkFullRow(int row){
        /* for row check if all element from 1-9 exist */
       for (int i=1; i<=BOARD_SIZE; i++){
           if (!isInRow(row, i)){
               return false;
           }
       }
       return true;
    }

    private boolean checkFullColumn(int col){
        // for col check if all element from 1-9 exist
        for (int i=1; i<=BOARD_SIZE; i++){
            if (!isInCol(col, i)){
                return false;
            }
        }
        return true;
    }

    private boolean checkFullSquare(int row, int col){
        // for square check if all element from 1-9 exist
        for (int i=1; i<=BOARD_SIZE; i++){
            if (!isInSquare(row, col, i)){
                return false;
            }
        }
        return true;
    }

    private boolean checkFullBoard(){

        boolean isBoardFull = true;

        for (int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j < BOARD_SIZE; j++){
                if (board[i][j] == EMPTY){
                    isBoardFull = false;
                    break;
                }
            }
            if (!isBoardFull){
                break;
            }
        }

        return isBoardFull;
    }


    private boolean checkBoardWining(){

        /*
        if board is not full than we can be certain there is not win
        if board is full we set is win to true ans start checking all the board
         */
        boolean isWin = checkFullBoard();

        if (isWin) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++){
                    // if row and col divide by 3 than we check square as well
                    if (i % 3 == 0 && j %3 == 0){
                        isWin = checkFullRow(i) && checkFullColumn(j) && checkFullSquare(i, j);
                    }
                    else{
                        isWin = checkFullRow(i) && checkFullColumn(j);
                    }
                    if (!isWin){
                        break;
                    }

                }
                if (!isWin){
                    break;
                }
            }
        }

        return isWin;
    }

    private int[][] convertArrayToTwoDimensions(ArrayList<String> originalBoard){
        int[][] convertedBoard = new int[originalBoard.size()][];
        for (int i = 1; i < originalBoard.size(); i++) {
            for (int j = 1; j < originalBoard.size(); j++){
                convertedBoard[i][j] = Integer.parseInt(originalBoard.get((i*j)-1));
            }
        }
        return convertedBoard;
    }

    private boolean checkNewEntering(int number, int position){

        int row = position/BOARD_SIZE;
        int column = position % BOARD_SIZE;

        return !isInRow(row, number)  &&  !isInCol(column, number)  &&  !isInSquare(row, column, number);
    }


    public String checkBoard(ArrayList<String> originalBoard, int number, int position){
        // return string depend if user win or enter valid/ not valid number (todo should be enum)

        board = this.convertArrayToTwoDimensions(originalBoard);

        boolean isNewEnterValid = this.checkNewEntering(number, position);
        if (isNewEnterValid) {
           if (this.checkBoardWining()){
               return "Win";
           }
           return "Valid Entering";
        } else {
            return "Wrong Entering";
        }
    }
}
