public class StopSignal {
    private volatile boolean stop = false;

    public void requestStop() {
        stop = true;
    }

    public boolean shouldStop() {
        return stop;
    }
}
