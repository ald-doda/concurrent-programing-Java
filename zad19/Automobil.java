package zad19;

import java.util.Random;

public class Automobil implements Runnable {
    private final int id;
    private final Most most;
    private boolean saLijeve;
    private final Random random = new Random();

    public Automobil(int id, Most most, boolean saLijeve) {
        this.id = id;
        this.most = most;
        this.saLijeve = saLijeve;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Automobil " + id + " boravi u "
                        + (saLijeve ? "lijevom gradu." : "desnom gradu."));

                Thread.sleep(random.nextInt(500, 2001));

                most.udji(id, saLijeve);
                try {
                    Thread.sleep(700);
                    saLijeve = !saLijeve;
                } finally {
                    most.izadji(id);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}