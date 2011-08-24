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

//        public static
//      let(:game) { Game.new '120120000' }
//      context 'and player1 wins' do
//        before { game.mark 7 }
//        its(:board) { should == '120120100' }
//        it { should be_over }
//        it { should_not be_a_tie }
//        its(:turn)  { should be nil }
//        specify('player1 should be the winner') { subject.status(1).should be :wins }
//        specify('player2 should be the loser')  { subject.status(2).should be :loses }
//      end
//    end


}

