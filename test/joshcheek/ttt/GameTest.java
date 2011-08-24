package joshcheek.ttt;

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

//        public void testGameIsOverWhenPlayer1Wins() {
//            Game game = new Game("120120000");
//            game.mark(7);
//            assertTrue(game.isOver());
//        }

//        public static
//      let(:game) { Game.new '120120000' }
//      context 'and player1 wins' do
//        before { game.mark 7 }
//        it { should_not be_a_tie }
//        its(:turn)  { should be nil }
//        specify('player1 should be the winner') { subject.status(1).should be :wins }
//        specify('player2 should be the loser')  { subject.status(2).should be :loses }
//      end
//    end

    // winning states:
        private void assertWinningState(String board, int player) {
            Game game = new Game(board);
            assertTrue(game.isOver());
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

//    describe 'winning states' do
//        ['
// ].each do |configuration, winner|
//          it { should_not be_a_tie }
//          its(:winner) { should be winner }
//        end
//      end
//    end
//
//    describe 'non winning states' do
//      [ '000000000',
//        '100000000',
//        '100020000',
//        '101020000',
//        '121020000',
//        '121020010',
//        '121220010',
//        '121221010',
//        '121221012', ].each do |configuration|
//        context configuration do
//          subject { Game.new configuration }
//          it { should_not be_over }
//          it { should_not be_a_tie }
//          its(:winner) { should be nil }
//        end
//      end
//      context "121221112, a tied state" do
//        subject { Game.new '121221112' }
//        it { should be_over }
//        it { should be_a_tie }
//        its(:winner) { should be nil }
//        specify("status(1) should be :ties") { subject.status(1).should be :ties }
//        specify("status(2) should be :ties") { subject.status(2).should be :ties }
//      end
//    end

}

