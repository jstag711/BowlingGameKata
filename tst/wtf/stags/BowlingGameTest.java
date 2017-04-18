package wtf.stags;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {
    private final BowlingGame game = new BowlingGame();
    
    @Test
    public void testGutterGame() throws Exception {
        rollNTimes(20, 0);
        assertEquals(0, game.score());
    }
    
    @Test
    public void testAllOnes() throws Exception {
        rollNTimes(20, 1);
        assertEquals(20, game.score());
    }
    
    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        game.roll(1);
        
        rollNTimes(17, 0);
        
        assertEquals(12, game.score());
    }
    
    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        game.roll(1);
        game.roll(1);

        rollNTimes(16, 0);
        
        assertEquals(14, game.score());
    }
    
    @Test
    public void testPerfectGame() throws Exception {
        throwNStrikes(12);
        
        assertEquals(300, game.score());
    }
    
    @Test
    public void testDammit() throws Exception {
        throwNStrikes(9);
        rollSpare();
        rollStrike();
        
        assertEquals(279, game.score());
    }

    private void throwNStrikes(int n) {
        for (int i = 0; i < n; i++) {
            rollStrike();
        }
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(9);
        game.roll(1);
    }
    
    private void rollNTimes(int n, int numPins) {
        for (int i = 0; i < n; i++) {
            game.roll(numPins);
        }
    }
}
