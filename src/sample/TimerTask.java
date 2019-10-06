package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimerTask extends Thread {
    static int min=0;
    static int sec=0;

    Timeline timel = new Timeline(new KeyFrame(Duration.millis(1000), ev ->{
        sec++;
        if (sec>59) {
            min++;
            sec=0;
        }
        Main.timer_game_task.setText("Time: " + min + "min " +sec + "sec ");
    }));
    @Override
    public void run() {
        while (!isInterrupted()) {
            timel.play();
        }
    }
}
