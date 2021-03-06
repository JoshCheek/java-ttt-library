package com.joshcheek.ttt.library;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class RatingTest extends junit.framework.TestCase {

    public void testItRatesAs1IfPlayerWon() {
        assertEquals(1.0, Rating.rate_for("111220000", 1));
    }

    public void testItRatesAsNegative1IfPlayerLost() {
        assertEquals(-1.0, Rating.rate_for("110222001", 1));
    }

    public void testItRatesAs1IfABoardIsAGuaranteedWin() {
        assertEquals(1.0, Rating.rate_for("110220000", 1));
    }

    public void testItRatesAsNegative1IfABoardIsAGuaranteedLoss() {
        assertEquals(-1.0, Rating.rate_for("110220100", 1));
    }

    public void testItRatesAs0IfBoardIsAGuaranteedTie() {
        assertEquals(0.0, Rating.rate_for("112221100", 1));
    }

    public void testItRatesForBothPlayer1AndPlayer2() {
        assertEquals(1.0,  Rating.rate_for("110220000", 1));
        assertEquals(-1.0, Rating.rate_for("110220000", 2));
    }

    public void testItRatesPlayer1AndPlayer2TheSameIfBoardIsGuaranteedToTie() {
        assertEquals(Rating.rate_for("112221100", 1), Rating.rate_for("112221100", 2));
    }

    // when it doesn't have a guaranteed win
        public void testRatingsHaveRelativeMeritSuchThatAMoveWithMoreOpportunitiesToWinWillBeRatedHigher() {
            double better = Rating.rate_for("121001200", 1);
            Double worse  = Rating.rate_for("121100200", 1);
            assertTrue(better > worse);
            assertFalse(1.0 == better);
            assertFalse(1.0 == worse);
        }


    public void testItKnowsRatingsForCongruentBoards() {
        assertCloseEnough("100000000", 1, "001000000", 1);
        assertCloseEnough("100000000", 1, "000000100", 1);
        assertCloseEnough("100000000", 1, "000000001", 1);
        assertCloseEnough("100000000", 2, "001000000", 2);
        assertCloseEnough("100000000", 2, "000000100", 2);
        assertCloseEnough("100000000", 2, "000000001", 2);
    }

    private void assertCloseEnough(String board1, int player1, String board2, int player2) {
        double rating1 = Rating.rate_for(board1, player1);
        double rating2 = Rating.rate_for(board2, player2);
        double delta   = Math.abs(rating1 - rating2);
        assertTrue(delta < 0.0000001);
        // equals with a delta
    }
}
