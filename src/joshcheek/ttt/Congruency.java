package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Congruency {

    public static boolean areCongruent(String board1, String board2) {
        for(String congruentBoard : congruents(board1))
            if(congruentBoard.equals(board2))
                return true;
        return false;
    }

    public static String[] congruents(String board) {
        return new String[]{
            newBoard(board, 0, 1, 2, 3, 4, 5, 6, 7, 8),
            newBoard(board, 6, 3, 0, 7, 4, 1, 8, 5, 2),
            newBoard(board, 8, 7, 6, 5, 4, 3, 2, 1, 0),
            newBoard(board, 2, 5, 8, 1, 4, 7, 0, 3, 6),
            newBoard(board, 6, 7, 8, 3, 4, 5, 0, 1, 2),
            newBoard(board, 0, 3, 6, 1, 4, 7, 2, 5, 8),
            newBoard(board, 2, 1, 0, 5, 4, 3, 8, 7, 6),
            newBoard(board, 8, 5, 2, 7, 4, 1, 6, 3, 0),
        };
    }

    private static String newBoard(String board, int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        return new String(new char[]{
                board.charAt(a),
                board.charAt(b),
                board.charAt(c),
                board.charAt(d),
                board.charAt(e),
                board.charAt(f),
                board.charAt(g),
                board.charAt(h),
                board.charAt(i),
        });
    }


}
