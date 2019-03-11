package aula03;

import java.util.Arrays;

public class JGaloController implements JGaloInterface {

    private enum playerIdentifier{
        player1('X'), player2('O');

        private char value;
        playerIdentifier(char value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

    }

    private static final char[] PLAYERS_IDENTIFIERS = {' ', 'X', 'O'};

    private int[][] board;
    private int current_player;
    private int count_plays = 0;

    public JGaloController(){

        board = new int[3][3];
        for (int[] current_board_line : board)
            Arrays.fill(current_board_line, -10);

        current_player = 1;
    }

    @Override
    public char getActualPlayer() {
        return PLAYERS_IDENTIFIERS[current_player];
    }

    @Override
    public boolean setJogada(int lin, int col) {

        lin--;
        col--;
        count_plays++;

        if(board[lin][col] == -10){
            board[lin][col] = current_player;
            current_player = current_player%2 + 1;

            return true;
        }

        return false;
    }

    @Override
    public boolean isFinished() {
        return checkIfWinner() != 0 || checkHaveMorePlays();
    }

    @Override
    public char checkResult() {
        return PLAYERS_IDENTIFIERS[checkIfWinner()];
    }

    private int checkIfWinner(){

        int current_sum_line;
        int current_sum_col;
        int current_sum_diag1 = 0;
        int current_sum_diag2 = 0;

        for(int index1 = 0; index1 < board.length; index1++){
            current_sum_line = 0;
            current_sum_col = 0;

            current_sum_diag1 += board[index1][index1];
            current_sum_diag2 += board[board.length - index1 - 1][index1];

            for(int index2 = 0; index2 < board.length; index2++){
                current_sum_line += board[index1][index2];
                current_sum_col += board[index2][index1];
            }

            if(current_sum_line == 3 || current_sum_col == 3 )
                return 1;
            if(current_sum_line == 6 || current_sum_col == 6 )
                return 2;
        }

        if(current_sum_diag1 == 3 || current_sum_diag2 == 3)
            return 1;
        if(current_sum_diag1 == 6 || current_sum_diag2 == 6)
            return 2;


        return 0;
    }

    private boolean checkHaveMorePlays(){
        return count_plays == 9;
    }
}
