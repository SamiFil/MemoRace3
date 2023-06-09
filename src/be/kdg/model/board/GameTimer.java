package be.kdg.model.board;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;


/**
 * Sami Filjak
 * 16/02/2023
 */
public class GameTimer extends Group {
    private AudioClip geluid = new AudioClip(this.getClass().getResource("/NBA_timer.wav").toString());
    private final Timeline timeline;
    private final Label timerLabel;
    private final long startTime;

    public GameTimer(){
        timerLabel = new Label("00:00:00");
        timerLabel.setId("playerLabel");
        setId("stopwatch-container");
        timerLabel.getStyleClass().addAll("display", "milliseconds");
        getChildren().add(timerLabel);

        startTime = System.currentTimeMillis();

        // Creeeren van een TimeLine object om de verstreken tijd weer te geven in minuten, seconden en milliseconden
        timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            // Bepaalt de tijd die is verstreken sinds het begin van het spel
            long tijdVerstreken = System.currentTimeMillis() - startTime;
            int minuten = (int) (tijdVerstreken / (60 * 1000));
            int seconden = (int) ((tijdVerstreken / 1000) % 60);
            int milliSeconden = (int) (tijdVerstreken % 1000);
            timerLabel.setText(String.format("%02d:%02d:%02d", minuten, seconden, milliSeconden / 10));
        }));
        // De cyclus van de timeline op oneindig zetten
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void stop() {
        geluid.stop();
        timeline.stop();
    }

    public AudioClip getGeluid() {
        return geluid;
    }


}

