package be.kdg.model.player;

/**
 * Sami Filjak
 * 20/03/2023
 */
public class Score {
    private String playerName;
    private int score;

    public Score(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }


    public String toString() {
        return playerName + ": " + score;
    }

}
