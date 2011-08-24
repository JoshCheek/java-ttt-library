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
        return winner() != -1 || isFull();
    }

    private boolean isFull() {
        for(char player : board)
            if(!isPlayer(player))
                return false;
        return true;
    }

    public int winner() {
        for(int[] positions : winningStates()) {
            char p1=board[positions[0]], p2=board[positions[1]], p3=board[positions[2]];
            if( isPlayer(p1) && isSamePlayer(p1, p2, p3) )
                return numForPlayer(p1);
        }
        return -1;
    }

    private int numForPlayer(char player) {
        return  player == '1' ? 1 :
                player == '2' ? 2 : -1;
    }

    private boolean isPlayer(char player) {
        return player == '1' || player == '2';
    }

    private boolean isSamePlayer(char a, char b, char c) {
        return a == b && b == c;
    }

    private int[][] winningStates() {
        return new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
        };

    }

    public boolean isTie() {
        return isOver() && winner() == -1;
    }

    public int[] availableMoves() {
        if(isOver())
            return new int[0];
        int availableMoves[] = new int[numPositionsAvailable()];
        copyAvailableMovesInto(availableMoves);
        return availableMoves;
    }

    private void copyAvailableMovesInto(int[] availableMoves) {
        for(int read=0, write=0; read<9; ++read)
            if(isAvailable(read))
                availableMoves[write++]=read+1;
    }

    public int numPositionsAvailable() {
        int size=0;
        for(int read=0; read<9; ++read) if(isAvailable(read)) ++size;
        return size;
    }

    private boolean isAvailable(int position) {
        return !isPlayer(board[position]);
    }
}
