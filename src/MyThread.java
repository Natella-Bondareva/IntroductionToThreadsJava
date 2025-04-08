
public class MyThread extends Thread {
    private final int id;
    private final double step;
    private final StopSignal stopSignal;

    public MyThread(int id, double step, StopSignal stopSignal) {
        this.id = id;
        this.step = step;
        this.stopSignal = stopSignal;
    }

    @Override
    public void run() {
        double sum = 0;
        double count = 0;

        while (!stopSignal.shouldStop()) {
            sum += step;
            count++;
            try {
                Thread.sleep(10); // Щоб не бігав занадто швидко
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("Потік " + id + ": сума = " + sum + ", кількість доданків = " + count);
    }
}
