package ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/24/11
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */

public class GameTest extends junit.framework.TestCase {
    public void setUp() throws Exception {
    }

    public static void testItHasNoMovesWhenCreatedWithoutAnArgument() {
        assertEquals(new Game().board(), "000000000");
    }
                         /*
    // when it is created with an unfinished board
        // with an equal number of 1s and 2s
            public static void testItKnowsItsBoard() {
                String board = "120000000";
                ? game = ?.new(board);
                assertEqual(game.board(), board);
            }
            public static void testItKnowsItsTurn() {
                String board = "120000000";
                ? game = ?.new(board);
                assertEqual(game.turn(), 1);
            }
            public static void testItMarksTheBoardWithTheCurrentPlayersNumber() {
                String board = "120000000";
                ? game = ?.new(board);
                game.mark(4)
                assertEqual(game.board(), "120100000");
            }
        // with more 1s than 2s
            public static void testItKnowsItsBoard() {
                String board = "120100000";
                ? game = ?.new(board);
                assertEqual(game.board(), board);
            }
            public static void testItKnowsItsTurn() {
                String board = "120100000";
                ? game = ?.new(board);
                assertEqual(game.turn(), 2);
            }
            public static void testItMarksTheBoardWithTheCurrentPlayersNumber() {
                String board = "120100000";
                ? game = ?.new(board);
                game.mark(7);
                assertEqual(game.board(), "120100200");
            }
                 */
}

