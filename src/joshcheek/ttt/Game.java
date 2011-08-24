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
        board[i-1] = '1';
    }
}
