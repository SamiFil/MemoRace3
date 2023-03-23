package be.kdg.model.board;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

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

        timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            long elapsedTime = System.currentTimeMillis() - startTime;
            int minutes = (int) (elapsedTime / (60 * 1000));
            int seconds = (int) ((elapsedTime / 1000) % 60);
            int millis = (int) (elapsedTime % 1000);
            timerLabel.setText(String.format("%02d:%02d:%02d", minutes, seconds, millis / 10));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public Label getTimerLabel() {
        return timerLabel;
    }

    public int getSeconden() {
        String timerLabelText = timerLabel.getText();
        String[] timerLabelParts = timerLabelText.split(":");
        int seconds = Integer.parseInt(timerLabelParts[1]);
        return seconds;
    }
    public void stop() {
        geluid.stop();
        timeline.stop();
    }

    public AudioClip getGeluid() {
        return geluid;
    }


}

