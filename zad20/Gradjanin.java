package zad20;

import java.util.Random;

public class Gradjanin implements Runnable {
    private final int id;
    private final Autobus autobus;
    private final int brojStanica;
    private final Random random = new Random();

    private int stanica;

    public Gradjanin(int id, Autobus autobus, int brojStanica) {
        this.id = id;
        this.autobus = autobus;
        this.brojStanica = brojStanica;
        this.stanica = random.nextInt(1, brojStanica + 1);
    }

    @Override
    public void run() {
        try {
            while (true) {
                int odrediste;

                do {
                    odrediste = random.nextInt(1, brojStanica + 1);
                } while (odrediste == stanica);

                autobus.udji(id, stanica, odrediste);
                autobus.izadji(id, odrediste);

                stanica = odrediste;

                System.out.println("Gradjanin " + id
                        + " seta u blizini stanice " + stanica);

                Thread.sleep(random.nextInt(500, 2001));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}