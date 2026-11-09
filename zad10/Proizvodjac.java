package zad10;

public class Proizvodjac implements Runnable {
    private final Bafer bafer;

    public Proizvodjac(Bafer bafer) {
        this.bafer = bafer;
    }

    @Override
    public void run() {
        try {
            for (int proizvod = 1; proizvod <= 5; proizvod++) {
                bafer.stavi(proizvod);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}