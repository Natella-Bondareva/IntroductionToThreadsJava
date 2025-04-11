import java.util.ArrayList;
import java.util.List;

public class ThreadManager extends Thread {
    private final List<StopSignal> signals;
    private final int[][] delays;

    public ThreadManager(List<StopSignal> signals, int[][] delays) {
        this.signals = signals;
        this.delays = delays;
    }

    @Override
    public void run() {
        for (int i = 0; i < signals.size(); i++) {
            int waitTime;
            if (i == 0)
                waitTime = delays[i][0];
            else
                waitTime = delays[i][0] - delays[i - 1][0];
            try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int index = delays[i][1];
                signals.get(index).requestStop();
        }
    }
}

