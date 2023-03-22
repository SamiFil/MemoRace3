package be.kdg.model.board;

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class GameTimer {
    private Timer gameTimer;
    private TimerTask task;
    private int secondsPassed;
    private Text timerTekst = new Text();
    private AudioClip geluid = new AudioClip(this.getClass().getResource("/NBA_timer.wav").toString());

    public GameTimer(){
        timerTekst.setWrappingWidth(300);
        timerTekst.setText("Timer: "+secondsPassed+" Seconden");
        timerTekst.setFill(Color.WHITE);
        timerTekst.setId("playerLabel");
        secondsPassed=0;
        gameTimer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                timerTekst.setText("Timer: "+secondsPassed+" Seconden");
            }
        };
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

