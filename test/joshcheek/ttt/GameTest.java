package joshcheek.ttt;

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
        assertEquals(new Game().board(), "000000000");
    }

    // when it is created with an unfinished board
        // with an equal number of 1s and 2s
            public void testItKnowsItsBoard() {
                Game game = new Game("120000000");
                assertEquals(game.board(), "120000000");
            }

            public void testItKnowsItsTurnWhenTurn1() {
                Game game = new Game("120000000");
                assertEquals(game.turn(), 1);
            }

            public void testItMarksTheBoardWithPlayerOnesNumber() {
                Game game = new Game("120000000");
                game.mark(4);
                assertEquals(game.board(), "120100000");
            }

        // with more 1s than 2s
            public void testItKnowsItsTurnWhenTurn2() {
                Game game = new Game("120100000");
                assertEquals(game.turn(), 2);
            }

            public void testItMarksTheBoardWithPlayerTwosNumber() {
                Game game = new Game("120100000");
                game.mark(7);
                assertEquals(game.board(), "120100200");
            }

    // when player1 can win
        public void testGameIsNotOverWhenPlayer1CanWin() {
            assertFalse(new Game("120120000").isOver());
        }
        // and player1 wins
            public void testGameMarksPlayer1WinCorrectly() {
                Game game = new Game("120120000");
                game.mark(7);
                assertEquals(game.board(), "120120100");
            }

            public void testGameIsOverWhenPlayer1Wins() {
                Game game = new Game("120120000");
                game.mark(7);
                assertTrue(game.isOver());
                assertFalse(game.isTie());
                assertEquals(game.winner(), 1);
            }

    // when player2 can win
        public void testGameIsNotOverWhenPlayer2CanWin() {
            assertFalse(new Game("121120000").isOver());
        }
        // and player 2 wins
            public void testGameMarksPlayer2WinCorrectly() {
                Game game = new Game("121120000");
                game.mark(8);
                assertEquals(game.board(), "121120020");
            }

            public void testGameIsOverWhenPlayer2Wins() {
                Game game = new Game("121120000");
                game.mark(8);
                assertTrue(game.isOver());
                assertFalse(game.isTie());
                assertEquals(game.winner(), 2);
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
                assertEquals(game.board(), "121221112");
                assertEquals(game.winner(), -1);
            }

    // winning states:
        private void assertWinningState(String board, int player) {
            Game game = new Game(board);
            assertTrue(game.isOver());
            assertFalse(game.isTie());
            assertEquals(game.winner(), player);
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
            assertEquals(game.winner(), -1);
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
            assertEquals(game.winner(), -1);
        }

    // available moves
        public void testAvailableMovesWhenMovesAreAvailable() {
            assertArrayEquals(new Game("000000000").availableMoves(), new int[]{1,2,3,4,5,6,7,8,9});
            assertArrayEquals(new Game("100000000").availableMoves(), new int[]{  2,3,4,5,6,7,8,9});
            assertArrayEquals(new Game("100020000").availableMoves(), new int[]{  2,3,4,  6,7,8,9});
            assertArrayEquals(new Game("101020000").availableMoves(), new int[]{  2,  4,  6,7,8,9});
            assertArrayEquals(new Game("121020000").availableMoves(), new int[]{      4,  6,7,8,9});
            assertArrayEquals(new Game("121020010").availableMoves(), new int[]{      4,  6,7,  9});
            assertArrayEquals(new Game("121220010").availableMoves(), new int[]{          6,7,  9});
            assertArrayEquals(new Game("121221010").availableMoves(), new int[]{            7,  9});
            assertArrayEquals(new Game("121221210").availableMoves(), new int[]{                9});
            assertArrayEquals(new Game("121221211").availableMoves(), new int[]{                 });
        }

        public void testAvailableMovesWhenGameIsOver() {
            assertArrayEquals(new Game("111000000").availableMoves(), new int[]{} );
        }

//    describe '#pristine_mark' do
//      let(:game) { Game.new '000000000' }
//      subject { game.pristine_mark 1 }
//      it { should be_an_instance_of Game }
//      its(:board) { should == '100000000' }
//      it 'leaves the original in its current condition' do
//        subject
//        game.board.should == '000000000'
//      end
//    end

}

