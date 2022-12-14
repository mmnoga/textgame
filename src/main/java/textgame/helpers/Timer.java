package textgame.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class Timer {
    private long durationTime;
    private long start;
    private java.util.Timer timer;

    public Timer(long durationTime) {
        this.durationTime = durationTime;
    }

    private long secToMs(long seconds){
        return seconds * 1000;
    }

    public void start() {
        start = System.currentTimeMillis();
        timer = new java.util.Timer();
        timer.schedule(new EndTask(), secToMs(durationTime));
    }

    public void printElapsedTime() {
        long time = System.currentTimeMillis() - start;
        System.out.print("Elapsed time: ");
        System.out.print((new SimpleDateFormat("mm:ss")).format(new Date(time)));
        System.out.print(" [min:sec]");
    }

    private class EndTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Time's up!");
            timer.cancel();
            System.exit(0);
        }
    }

}
