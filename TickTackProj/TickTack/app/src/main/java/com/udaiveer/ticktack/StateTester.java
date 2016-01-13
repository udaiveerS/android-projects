package com.udaiveer.ticktack;

/**
 * Created by udaiveer on 1/13/16.
 */
public class StateTester {

    public static int checkDiagonalBackward(int[][] state) {
        int startIndex = state.length-1;
        int endIndex = startIndex;
        int matrixSize = startIndex;
        int numberOfDiag = state.length*2 -1;

        int colStart = 0;
        int iterAfterMainDiag = 0;

        for(int i = 0; i <  numberOfDiag ; i++) {
            if(i > matrixSize) {
                startIndex = 0;
                endIndex--;
                iterAfterMainDiag++;
            } else {
                startIndex = matrixSize - i;
            }

            int player1 = 0;
            int player2 = 0;
            while(startIndex <= endIndex) {
                int jIndex = colStart + iterAfterMainDiag;
                if(state[startIndex][jIndex] == 1) {
                    player1++;
                    if(player1 == 3) return 1;
                }
                if(state[startIndex][jIndex] == 2) {
                    player2++;
                    if(player2 == 3) return 2;
                }
                startIndex++;
                colStart++;
            }

            if(i == matrixSize) {
                endIndex = matrixSize;
            }
            colStart = 0;
        }
        return 0;
    }

    public static int checkDiagonalForward(int[][] state) {
        int numberOfDiag = state.length*2 -1;
        int matrixSize = state.length-1;
        int start_i = 0;
        int end_i = 0;
        int start_j = 0;

        for(int i = 0; i <  numberOfDiag ; i++) {

            //Iterate over everything including reverse middle diagonal
            if(i <= matrixSize){
                int tempStart_j = start_j;
                int player1 = 0;
                int player2 = 0;
                while(start_i <= end_i) {
                    if (state[start_i][tempStart_j] == 1) {
                        player1++;
                        if (player1 == 3)
                            return 1;
                    }
                    if (state[start_i][tempStart_j] == 2) {
                        player2++;
                        if (player2 == 3)
                            return 2;
                    }
                    start_i++;
                    tempStart_j--;
                }
                start_i = 0;

                start_j++;
                end_i++;
            }

            // main diagonal was processed reset bounds for start/end_(i,j)
            if(i == matrixSize) {
                // the next column will always start at 2 for any NxN matrix
                start_i = 1;
                // the diagonal will all end at N for any square matrix
                end_i = matrixSize;
                // start_j remains constant
                start_j = matrixSize;
            }

            //Iterate over everything  after reverse middle diagonal
            if(i > matrixSize){
                int tempStart_i = start_i;
                int tempStart_j = start_j;
                int player1 = 0;
                int player2 = 0;
                while(tempStart_i <= end_i) {
                    if (state[start_i][tempStart_j] == 1) {
                        player1++;
                        if (player1 == 3)
                            return 1;
                    }
                    if (state[start_i][tempStart_j] == 2) {
                        player2++;
                        if (player2 == 3)
                            return 2;
                    }
                    tempStart_i++;
                    tempStart_j--;
                }
                start_i++;
            }

        }
        return 0;
    }
    //columns rows

    public static int checkColumns(int[][] state) {
        for(int i = 0; i < state.length; i++) {
            int player1 = 0;
            int player2 = 0;
            for(int j = 0; j < state.length; j++) {
                if(state[j][i] == 1) {
                    player1++;
                    if(player1 == 3) return 1;
                }
                if(state[j][i] == 2) {
                    player2++;
                    if(player2 == 3) return 2;
                }
            }
        }
        return 0;
    }

    public static int checkRows(int[][] state) {
        for(int i = 0; i < state.length; i++) {
            int player1 = 0;
            int player2 = 0;
            for(int j = 0; j < state.length; j++) {
                if(state[i][j] == 1) {
                    player1++;
                    if(player1 == 3) return 1;
                }
                if(state[i][j] == 2) {
                    player2++;
                    if(player2 == 3) return 2;
                }
            }

        }
        return 0;
    }
}
