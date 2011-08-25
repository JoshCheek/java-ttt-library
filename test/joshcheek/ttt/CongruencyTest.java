package joshcheek.ttt;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class CongruencyTest extends junit.framework.TestCase {

    private void assertCongruent(String board1, String board2) {
        assertTrue(Congruency.areCongruent(board1, board2));
    }

    private void assertNotCongruent(String board1, String board2) {
        assertFalse(Congruency.areCongruent(board1, board2));
    }

    public void testItKnows100000000_001000000_000000100_000000001AreAllCongruent() {
        assertCongruent("100000000", "001000000");
        assertCongruent("100000000", "000000100");
        assertCongruent("100000000", "000000001");
    }

    public void testItKnows120000000_100200000AreAllCongruent() {
        assertCongruent("120000000", "100200000");
    }

    public void testItKnows100020000_001020000_000020100_000020001AreAllCongruent() {
        assertCongruent("100020000", "001020000");
        assertCongruent("100020000", "000020100");
        assertCongruent("100020000", "000020001");
    }

    public void testItKnows120000001_100200001AreAllCongruent() {
        assertCongruent("120000001", "100200001");
    }

    public void testItKnows100020100_000020101_001020001_101020000AreAllCongruent() {
        assertCongruent("100020100", "000020101");
        assertCongruent("100020100", "001020001");
        assertCongruent("100020100", "101020000");
    }


    public void testItKnows100000000IsNotCongruentWith010000000() {
        assertNotCongruent("100000000", "010000000");
    }

    public void testItKnows100000000IsNotCongruentWith000010000() {
        assertNotCongruent("100000000", "000010000");
    }

    public void testItKnows100000000IsNotCongruentWith120000000() {
        assertNotCongruent("100000000", "120000000");
    }

    public void testItKnows010000000IsNotCongruentWith100000000() {
        assertNotCongruent("010000000", "100000000");
    }

    public void testItKnows010000000IsNotCongruentWith000010000() {
        assertNotCongruent("010000000", "000010000");
    }

    public void testItKnows010000000IsNotCongruentWith120000000() {
        assertNotCongruent("010000000", "120000000");
    }

    public void testItKnows000010000IsNotCongruentWith100000000() {
        assertNotCongruent("000010000", "100000000");
    }

    public void testItKnows000010000IsNotCongruentWith010000000() {
        assertNotCongruent("000010000", "010000000");
    }

    public void testItKnows000010000IsNotCongruentWith120000000() {
        assertNotCongruent("000010000", "120000000");
    }

    public void testItKnows120000000IsNotCongruentWith100000000() {
        assertNotCongruent("120000000", "100000000");
    }

    public void testItKnows120000000IsNotCongruentWith010000000() {
        assertNotCongruent("120000000", "010000000");
    }

    public void testItKnows120000000IsNotCongruentWith000010000() {
        assertNotCongruent("120000000", "000010000");
    }

    public void testItKnows120000000IsNotCongruentWith102000000() {
        assertNotCongruent("120000000", "102000000");
    }

    public void testItKnows120000000IsNotCongruentWith100020000() {
        assertNotCongruent("120000000", "100020000");
    }

    public void testItKnows120000000IsNotCongruentWith100000002() {
        assertNotCongruent("120000000", "100000002");
    }

    public void testItKnows102000000IsNotCongruentWith120000000() {
        assertNotCongruent("102000000", "120000000");
    }

    public void testItKnows102000000IsNotCongruentWith100020000() {
        assertNotCongruent("102000000", "100020000");
    }

    public void testItKnows102000000IsNotCongruentWith100000002() {
        assertNotCongruent("102000000", "100000002");
    }

    public void testItKnows100020000IsNotCongruentWith120000000() {
        assertNotCongruent("100020000", "120000000");
    }

    public void testItKnows100020000IsNotCongruentWith102000000() {
        assertNotCongruent("100020000", "102000000");
    }

    public void testItKnows100020000IsNotCongruentWith100000002() {
        assertNotCongruent("100020000", "100000002");
    }

    public void testItKnows100000002IsNotCongruentWith120000000() {
        assertNotCongruent("100000002", "120000000");
    }

    public void testItKnows100000002IsNotCongruentWith102000000() {
        assertNotCongruent("100000002", "102000000");
    }

    public void testItKnows100000002IsNotCongruentWith100020000() {
        assertNotCongruent("100000002", "100020000");
    }

    public void testItKnows110020000IsNotCongruentWith101020000() {
        assertNotCongruent("110020000", "101020000");
    }

    public void testItKnows110020000IsNotCongruentWith100020001() {
        assertNotCongruent("110020000", "100020001");
    }

    public void testItKnows101020000IsNotCongruentWith110020000() {
        assertNotCongruent("101020000", "110020000");
    }

    public void testItKnows101020000IsNotCongruentWith100020001() {
        assertNotCongruent("101020000", "100020001");
    }

    public void testItKnows100020001IsNotCongruentWith110020000() {
        assertNotCongruent("100020001", "110020000");
    }

    public void testItKnows100020001IsNotCongruentWith101020000() {
        assertNotCongruent("100020001", "101020000");
    }

    public void testItFindsCongruentBoards() {
        String[] expected = new String[]{"abcdefghi", "gdahebifc", "ihgfedcba", "cfibehadg", "ghidefabc", "adgbehcfi", "cbafedihg", "ifchebgda"};
        assertArrayEquals(expected, Congruency.congruents("abcdefghi"));
    }

}
