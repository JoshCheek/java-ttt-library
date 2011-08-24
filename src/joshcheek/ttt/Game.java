package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/24/11
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private char[] board;

    public static void main(String[] args) {

    }

    public Game() {
        this("000000000");
    }

    public Game(String board) {
        this.board = board.toCharArray();
    }

    public String board() {
        return new String(board);
    }

    public int turn() {
        return numOnesInBoard() - numTwosInBoard() + 1;
    }
    private int numOnesInBoard() {
        return countOccurrances('1');
    }

    private int numTwosInBoard() {
        return countOccurrances('2');
    }

    private int countOccurrances(char targetPlayer) {
        int occurrences = 0;
        for(char currentPlayer : board)
            if(currentPlayer == targetPlayer)
                occurrences++;
        return occurrences;
    }

    public void mark(int i) {
        board[i-1] = Integer.toString(turn()).charAt(0);
    }

    public boolean isOver() {
        return winner() != -1;
    }

    public int winner() {
        int[][] winningStates = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6},
        };
        for(int[] positions : winningStates) {
            int i1=positions[0], i2=positions[1], i3=positions[2];
            if( (board[i1] == '1' || board[i1] == '2') && board[i1] == board[i2] && board[i2] == board[i3] )
                return board[i1] == '1' ? 1 : 2;
        }
        return -1;
    }
}
