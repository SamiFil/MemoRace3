package be.kdg.model.player;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Sami Filjak
 * 20/03/2023
 */
public class HighScore {
    private String fileName;

    public HighScore(String fileName) {
    this.fileName = fileName;
    }

    //De gegeven score opslaan in highscores bestand
    public void saveHighScore(Score score) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(score.toString() + "\n");
        writer.close();
    }

    //De highscores van het tekstbestand opladen
    public List<Score> loadHighScores() throws IOException {
        List<Score> highScores = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Splitst de lijn op ": " om de spelersnaam en score te krijgen
            String[] parts = line.split(": ");
            String playerName = parts[0];
            int scores = Integer.parseInt(parts[1]);
            Score score = new Score(playerName, scores);
            highScores.add(score);
        }
        scanner.close();
        return highScores;
    }

    // Laadt de highscores uit het tekstbestand en toont ze in de applicatie.
    public void showHighScores(VBox vBox) throws IOException {
        List<Score> scores = loadHighScores();
        scores.sort(Comparator.comparingInt(Score::getScore).reversed());
        for (Score score : scores) {
            Label text = new Label();
            text.setId("label");
            text.setText(score.getPlayerName() + ": " + score.getScore() + " kaarten gewonnen");
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(text);
        }
    }
}
