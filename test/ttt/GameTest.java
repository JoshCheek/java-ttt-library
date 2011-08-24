package ttt;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/24/11
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameTest extends TestCase {
    public void testReturnNumber() {
        assertEquals(new Game().returnNumber(), 3);
    }
}
