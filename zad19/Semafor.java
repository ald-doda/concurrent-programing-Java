package zad19;

public class Semafor implements Runnable {
    private final Most most;

    public Semafor(Most most) {
        this.most = most;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                most.promijeniSmjer();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}