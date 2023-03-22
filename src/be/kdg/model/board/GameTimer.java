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
    private Timer gameTimer;
    private TimerTask task;
    private int secondsPassed;
    private Text timerTekst = new Text();
    private AudioClip geluid = new AudioClip(this.getClass().getResource("/NBA_timer.wav").toString());
    private final Timeline timeline;
    private final Label timerLabel;
    private final long startTime;

    public GameTimer(){
//        timerTekst.setWrappingWidth(300);
//        timerTekst.setText("Timer: "+secondsPassed+" Seconden");
//        timerTekst.setFill(Color.WHITE);
//        timerTekst.setId("timerTekst");
//        secondsPassed=0;
//        gameTimer = new Timer();
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                secondsPassed++;
//                timerTekst.setText("Timer: "+secondsPassed+" Seconden");
//            }
//        };
        timerLabel = new Label("00:00:00");
        timerLabel.setId("");
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
    public void start(){
        gameTimer.scheduleAtFixedRate(task,1000,1000);
    }

    public void stop() {
        geluid.stop();
        gameTimer.cancel();
        task.cancel();
    }

    public AudioClip getGeluid() {
        return geluid;
    }

    public Text getTimerTekst() {
        return timerTekst;
    }

    public Timer getGameTimer() {
        return gameTimer;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }
}

