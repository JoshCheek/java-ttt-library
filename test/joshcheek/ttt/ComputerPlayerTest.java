package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputerPlayerTest extends junit.framework.TestCase {

    private void assertCorrectMove(String initial, int player, String[] validMoves) {
        Game game = new Game(initial);
        ComputerPlayer computer = new ComputerPlayer(game);
        computer.takeTurn();
        assertInArray(validMoves, game.board());
    }

    private void assertCorrectMove(String initial, int player) {
        Game game = new Game(initial);
        ComputerPlayer computer = new ComputerPlayer(game);
        computer.takeTurn();
        assertEquals(1.0, Rating.rate_for(game.board(), player));
    }

    private void assertInArray(String[] strings, String target) {
        boolean inAry = false;
        for(String string : strings)
            if(string.equals(target))
                inAry = true;
        assertTrue(inAry);
    }

    private void assertInArray(int[] ints, int target) {
        boolean inAry = false;
        for(int crnt : ints) if(crnt == target) inAry = true;
        assertTrue(inAry);
    }

    public void testItMovesToAWinningStateWhenItCanWinAcrossTop() {
        assertCorrectMove("110200200", 1, new String[]{"111200200"});
    }

    public void testItMovesToAWinningStateWhenItCanWinAcrossBottomAndOpponentCanWinAcrossTop() {
        assertCorrectMove("220000110", 1);
    }

    public void testItMovesToAWinningStateWhenItCanWinVerticallyOnRhsOpponentCanWinToo() {
        assertCorrectMove("201201000", 1);
    }

    public void testItMovesToAWinningStateWhenItCanWinVerticallyOnLhsOpponentCanWinToo() {
        assertCorrectMove("120120000", 1);
    }

    public void testItAlwaysTakesAWinWhenItCanWinDiagonally() {
        assertCorrectMove("102210000", 1);
    }

    public void testMovesToAWinningStateWhenItCanWinInTwoPositions() {
        assertCorrectMove("120112020", 1);
    }

    public void testItMovesToAWinningStateWhenItCan2ndPlayerAnd1stCanAlsoWin() {
        assertCorrectMove("120021001", 2);
    }


//
//        context "Computer blocks opponent's win" do
//          moves_for [
//            ['120100000', 2, ['120100200']              , 'blocks lhs'                                ],
//            ['122110000', 2, ['122110200', '122110002'] , "blocks either of opponent's possible wins" ],
//            ['211200000', 1, ['211200100']              , 'blocks when first player'                  ],
//          ]
//        end
//

    public void testItFindsBestMovesForLikelyGameStates_makesBest1stMove() {
        assertCorrectMove("000000000", 1, new String[]{"100000000", "001000000", "000000100", "000000001"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveThatWillGuaranteeWinInFuture1() {
        assertCorrectMove("120000000", 1, new String[]{"120000100", "120010000", "120100000"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveThatWillGuaranteeWinInFuture2() {
        assertCorrectMove("100000002", 1, new String[]{"101000002", "100000102"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveThatWillGuaranteeWinInFuture3() {
        assertCorrectMove("100000020", 1, new String[]{"100000120", "101000020", "100010020"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveThatWillGuaranteeWinInFuture4() {
        assertCorrectMove("102000000", 1, new String[]{"102100000", "102000100", "102000001"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveThatWillGuaranteeWinNextTurn5() {
        assertCorrectMove("102100200", 1, new String[]{"102110200"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveWithHighestProbabilityOfWinInFuture6() {
        assertCorrectMove("100020000", 1, new String[]{"110020000", "100120000"});
    }

    public void testItFindsBestMovesForLikelyGameStates_makesMoveWithLowestProbabilityOfLosingInFuture7() {
        assertCorrectMove("100000000", 2, new String[]{"100020000"});
    }

    public void testBestMoveMakesTheBestMoveOnFirstBoard() {
        Game game = new Game("000000000");
        ComputerPlayer computer = new ComputerPlayer(game);
        assertInArray(new int[]{1, 3, 7, 9}, computer.bestMove());
    }

    public void testBestMovePowersTheTakeTurnMethodByFindingTheBestMove() {
        Game game = new Game("100000000");
        ComputerPlayer computer = new ComputerPlayer(game);
        assertEquals(5, computer.bestMove());
    }

}
