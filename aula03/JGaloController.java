package aula03;

import java.util.Arrays;

public class JGaloController implements JGaloInterface {

    // player0 (' ') is "tied player"; player1 ('X') is first player; player1 ('O') is second player
    private static final char[] PLAYERS_IDENTIFIERS = {' ', 'X', 'O'};

    private int[][] board;
    private int current_player;
    private int count_plays;
    private int winner;

    public JGaloController(){

        // initialize a new board with no moves (with values -10
        // instead of 1 or 2 (that corresponds to the players)
        board = new int[3][3];
        for (int[] current_board_row : board)
            Arrays.fill(current_board_row, -10);

        current_player = 1;     // player1 starts the game
        count_plays = 0;        // initially there are no moves
        winner = 0;             // initially there are no winners
    }

    @Override
    public char getActualPlayer() {
        return PLAYERS_IDENTIFIERS[current_player];
    }

    @Override
    public boolean setJogada(int lin, int col) {

        lin--;  // lin - 1 due to indexation
        col--;  // col - 1 due to indexation

        // verify if that cell is empty, to put the new user's move
        if(board[lin][col] == -10){
            board[lin][col] = current_player;
            current_player = current_player%2 + 1;

            count_plays++;

            return true;
        }

        // return false if the given cell already as been chosen by a player
        return false;
    }

    @Override
    public boolean isFinished() {
        return checkIfWinner() != 0 || checkHaveMorePlays();
    }

    @Override
    public char checkResult() {
        return PLAYERS_IDENTIFIERS[winner];
    }

    private int checkIfWinner(){

        int current_sum_row,
                current_sum_col,
                current_sum_diag1 = 0,
                current_sum_diag2 = 0;

        for(int index1 = 0; index1 < board.length; index1++){
            current_sum_row = 0;
            current_sum_col = 0;

            // to know how the diagonals are filled and
            // if one of them is totally filled with same user shots
            current_sum_diag1 += board[index1][index1];
            current_sum_diag2 += board[board.length - index1 - 1][index1];

            for(int index2 = 0; index2 < board.length; index2++){
                // to know how the rows and columns are filled and
                // if one of them is totally filled with same user shots
                current_sum_row += board[index1][index2];
                current_sum_col += board[index2][index1];
            }

            // verify if a row or a column is totally filled with the user1 or user2 moves
            if(current_sum_row == 3 || current_sum_col == 3 )
                return winner = 1;
            if(current_sum_row == 6 || current_sum_col == 6 )
                return winner = 2;
        }

        // verify if a diagonal is totally filled with the user1 or user2 moves
        if(current_sum_diag1 == 3 || current_sum_diag2 == 3)
            return winner = 1;
        if(current_sum_diag1 == 6 || current_sum_diag2 == 6)
            return winner = 2;

        return 0;   // return 0 if there are no winner yet
    }

    private boolean checkHaveMorePlays(){
        // check if there are more moves or if the board is totally full
        return count_plays == 9;
    }
}
