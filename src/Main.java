import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int[] delays = {5000, 8000, 3000, 5000, 10000, 2000, 9000};
        double[] steps = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7};

        int[][] indexedDelays = new int[delays.length][2];
        for (int i = 0; i < delays.length; i++) {
            indexedDelays[i][0] = delays[i]; // delay
            indexedDelays[i][1] = i;         // original index
        }

        Arrays.sort(indexedDelays, Comparator.comparingInt(a -> a[0]));

        List<StopSignal> signals = new ArrayList<>();
        List<MyThread> threads = new ArrayList<>();

        for (int i = 0; i < delays.length; i++) {
            StopSignal signal = new StopSignal();
            signals.add(signal);

            MyThread thread = new MyThread(i + 1, steps[i],signal);
            threads.add(thread);
            thread.start();
        }
        ThreadManager manager = new ThreadManager(signals, indexedDelays);
        manager.start();
    }
}