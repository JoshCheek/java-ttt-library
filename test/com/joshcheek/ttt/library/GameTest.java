package com.joshcheek.ttt.library;

import static org.junit.Assert.assertArrayEquals;

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
        assertEquals("000000000", new Game().board());
    }

    // when it is created with an unfinished board
        // with an equal number of 1s and 2s
            public void testItKnowsItsBoard() {
                Game game = new Game("120000000");
                assertEquals("120000000", game.board());
            }

            public void testItKnowsItsTurnWhenTurn1() {
                Game game = new Game("120000000");
                assertEquals(1, game.turn());
            }

            public void testItMarksTheBoardWithPlayerOnesNumber() {
                Game game = new Game("120000000");
                game.mark(4);
                assertEquals("120100000", game.board());
            }

        // with more 1s than 2s
            public void testItKnowsItsTurnWhenTurn2() {
                Game game = new Game("120100000");
                assertEquals(2, game.turn());
            }

            public void testItMarksTheBoardWithPlayerTwosNumber() {
                Game game = new Game("120100000");
                game.mark(7);
                assertEquals("120100200", game.board());
            }

    // when player1 can win
        public void testGameIsNotOverWhenPlayer1CanWin() {
            assertFalse(new Game("120120000").isOver());
        }
        // and player1 wins
            public void testGameMarksPlayer1WinCorrectly() {
                Game game = new Game("120120000");
                game.mark(7);
                assertEquals("120120100", game.board());
            }

            public void testGameIsOverWhenPlayer1Wins() {
                Game game = new Game("120120000");
                game.mark(7);
                assertTrue(game.isOver());
                assertFalse(game.isTie());
                assertEquals(1, game.winner());
            }

    // when player2 can win
        public void testGameIsNotOverWhenPlayer2CanWin() {
            assertFalse(new Game("121120000").isOver());
        }
        // and player 2 wins
            public void testGameMarksPlayer2WinCorrectly() {
                Game game = new Game("121120000");
                game.mark(8);
                assertEquals("121120020", game.board());
            }

            public void testGameIsOverWhenPlayer2Wins() {
                Game game = new Game("121120000");
                game.mark(8);
                assertTrue(game.isOver());
                assertFalse(game.isTie());
                assertEquals(2, game.winner());
            }

    // when the game can end in a tie
        public void testGameCanEndInATie() {
            assertFalse(new Game("121221012").isOver());
        }

        // and the game ends in a tie
            public void testGameEndsInATie() {
                Game game = new Game("121221012");
                game.mark(7);
                assertTrue(game.isOver());
                assertTrue(game.isTie());
                assertEquals("121221112", game.board());
                assertEquals(-1, game.winner());
            }

    // winning states:
        private void assertWinningState(String board, int player) {
            Game game = new Game(board);
            assertTrue(game.isOver());
            assertFalse(game.isTie());
            assertEquals(player, game.winner());
        }
        public void testItRecognizesAWinsForAllPlayersInAllPositions() {
            assertWinningState("111000000", 1);
            assertWinningState("000111000", 1);
            assertWinningState("000000111", 1);
            assertWinningState("222000000", 2);
            assertWinningState("000222000", 2);
            assertWinningState("000000222", 2);
            assertWinningState("100100100", 1);
            assertWinningState("010010010", 1);
            assertWinningState("001001001", 1);
            assertWinningState("200200200", 2);
            assertWinningState("020020020", 2);
            assertWinningState("002002002", 2);
            assertWinningState("100010001", 1);
            assertWinningState("001010100", 1);
            assertWinningState("200020002", 2);
            assertWinningState("002020200", 2);
        }

    // non winning states
        private void assertNonFinishedState(String board) {
            Game game = new Game(board);
            assertFalse(game.isOver());
            assertFalse(game.isTie());
            assertEquals(-1, game.winner());
        }
        public void testItRecognizesNonFinishedStates() {
            assertNonFinishedState("000000000");
            assertNonFinishedState("000000000");
            assertNonFinishedState("100000000");
            assertNonFinishedState("100020000");
            assertNonFinishedState("101020000");
            assertNonFinishedState("121020000");
            assertNonFinishedState("121020010");
            assertNonFinishedState("121220010");
            assertNonFinishedState("121221010");
            assertNonFinishedState("121221012");
        }

        public void testTiedState() {
            Game game = new Game("121221112");
            assertTrue(game.isOver());
            assertTrue(game.isTie());
            assertEquals(-1, game.winner());
        }

    // available moves
        public void testAvailableMovesWhenMovesAreAvailable() {
            assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, new Game("000000000").availableMoves());
            assertArrayEquals(new int[]{  2,3,4,5,6,7,8,9}, new Game("100000000").availableMoves());
            assertArrayEquals(new int[]{  2,3,4,  6,7,8,9}, new Game("100020000").availableMoves());
            assertArrayEquals(new int[]{  2,  4,  6,7,8,9}, new Game("101020000").availableMoves());
            assertArrayEquals(new int[]{      4,  6,7,8,9}, new Game("121020000").availableMoves());
            assertArrayEquals(new int[]{      4,  6,7,  9}, new Game("121020010").availableMoves());
            assertArrayEquals(new int[]{          6,7,  9}, new Game("121220010").availableMoves());
            assertArrayEquals(new int[]{            7,  9}, new Game("121221010").availableMoves());
            assertArrayEquals(new int[]{                9}, new Game("121221210").availableMoves());
            assertArrayEquals(new int[]{                 }, new Game("121221211").availableMoves());
        }

        public void testAvailableMovesWhenGameIsOver() {
            assertArrayEquals(new int[]{}, new Game("111000000").availableMoves());
        }

    // Game#pristineMove()
        public void testPristineMoveReturnsGameWithMoveMade() {
            Game initial = new Game("000000000");
            Game marked  = initial.pristineMove(1);
            assertEquals("100000000", marked.board());
        }

        public void testPristineMoveLeavesOriginalPristine() {
            Game initial = new Game("000000000");
            Game marked  = initial.pristineMove(1);
            assertEquals("000000000", initial.board());
        }

    public void testIsAvailable() {
        Game game = new Game("010200100");
        assertTrue(game.isAvailable(1));
        assertFalse(game.isAvailable(2));
        assertTrue(game.isAvailable(3));
        assertFalse(game.isAvailable(4));
        assertTrue(game.isAvailable(5));
        assertTrue(game.isAvailable(6));
        assertFalse(game.isAvailable(7));
        assertTrue(game.isAvailable(8));
        assertTrue(game.isAvailable(9));
    }

    public void testIsAvailableReturnsFalseForEveryPositionWhenGameIsOver() {
        assertNoMovesFor("111220000"); // player1 wins
        assertNoMovesFor("112221210"); // player2 wins
        assertNoMovesFor("112221121"); // tie game
    }

    private void assertNoMovesFor(String board) {
        Game game = new Game(board);
        assertArrayEquals(new int[0], game.availableMoves());
        for(int position=1; position<=8; ++position)
            assertFalse("" + position + " should not be available in " + game.board(),
                    game.isAvailable(position));
    }
}

