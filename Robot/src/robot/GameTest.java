import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void test00NewGameIsEmpty(){
        Game game = new Game();
        assertEquals(0, game.getRobots().size());
    }
}
