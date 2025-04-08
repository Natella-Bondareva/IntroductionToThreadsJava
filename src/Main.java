import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] delays = {5000, 8000, 3000};
        double[] steps = {0.1, 0.2, 0.3};

        List<StopSignal> signals = new ArrayList<>();
        List<MyThread> threads = new ArrayList<>();

        for (int i = 0; i < delays.length; i++) {
            StopSignal signal = new StopSignal();
            signals.add(signal);

            MyThread thread = new MyThread(i + 1, steps[i],signal);
            threads.add(thread);
            thread.start();
        }
        ThreadManager manager = new ThreadManager(signals, delays);
        manager.start();
    }
}