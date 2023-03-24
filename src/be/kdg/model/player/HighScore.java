package be.kdg.model.player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Sami Filjak
 * 20/03/2023
 */
public class HighScore {
    private String fileName = "highscores.txt";

    public HighScore(String fileName) {
    this.fileName = fileName;
    }

    public void saveHighScore(Score score) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(score.toString() + "\n");
        writer.close();
    }

    public List<Score> loadHighScores() throws IOException {
        List<Score> highScores = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String playerName = parts[0];
            int scores = Integer.parseInt(parts[1]);
            Score score = new Score(playerName, scores);
            highScores.add(score);
        }
        scanner.close();
        return highScores;
    }

    public void showHighScores() throws IOException {
        List<Score> scores = loadHighScores();
        scores.sort(Comparator.comparingInt(Score::getScore).reversed());
        for (Score score : scores) {
            System.out.println(score.getPlayerName() + ": " + score.getScore() + " cards won");
        }
    }
}
