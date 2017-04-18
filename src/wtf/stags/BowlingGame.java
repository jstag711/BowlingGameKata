package wtf.stags;

public class BowlingGame {
    
    private int currentRoll = 0;
    private int[] rolls = new int[21];

    public void roll(int numPins) {
        rolls[currentRoll] = numPins;
        currentRoll ++;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += rolls[rollIndex] + rolls[rollIndex + 1];
            if (isStrike(rollIndex)) {
                score += rolls[rollIndex + 2];
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex+1] == 10;
    }

}
