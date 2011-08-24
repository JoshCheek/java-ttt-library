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
        int numOnesInBoard = 0;
        int numTwosInBoard = 0;
        for(char player : board)
            if(player == '1')
                numOnesInBoard++;
            else if(player == '2')
                numTwosInBoard++;
        return numOnesInBoard - numTwosInBoard + 1;
    }

    public void mark(int i) {
        board[i-1] = Integer.toString(turn()).charAt(0);
    }

    public boolean isOver() {
        int[][] winningStates = {
                {0, 1, 2}
        };
        for(int[] positions : winningStates) {
            int i1=positions[0], i2=positions[1], i3=positions[2];
            if( board[i1] == board[i2] && board[i2] == board[i3] )
                return true;
        }
        return false;
    }

    public int winner() {
        return 1;
    }
}
