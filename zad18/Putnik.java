package zad18;

import java.util.Random;

public class Putnik implements Runnable {
    private final int id;
    private final Rolerkoster rolerkoster;
    private final Random random = new Random();

    public Putnik(int id, Rolerkoster rolerkoster) {
        this.id = id;
        this.rolerkoster = rolerkoster;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Putnik " + id + " seta po luna parku.");
                Thread.sleep(random.nextInt(500, 2001));

                rolerkoster.udji(id);
                rolerkoster.izadji(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}