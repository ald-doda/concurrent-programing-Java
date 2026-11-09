package zad10;

public class Potrosaci implements Runnable {
    private final int id;
    private final Bafer bafer;

    public Potrosaci(int id, Bafer bafer) {
        this.id = id;
        this.bafer = bafer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                bafer.uzmi(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}