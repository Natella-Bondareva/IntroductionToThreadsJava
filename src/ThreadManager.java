import java.util.ArrayList;
import java.util.List;

public class ThreadManager extends Thread {
    private final List<StopSignal> signals;
    private final int[] delays;

    public ThreadManager(List<StopSignal> signals, int[] delays) {
        this.signals = signals;
        this.delays = delays;
    }

    @Override
    public void run() {
        for (int i = 0; i < signals.size(); i++) {
            int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(delays[index]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                signals.get(index).requestStop();
            }).start();
        }
    }
}
