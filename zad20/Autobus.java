package zad20;

public class Autobus implements Runnable {
    private final int kapacitet;
    private final int brojStanica;

    private int brojPutnika = 0;
    private int trenutnaStanica = 1;
    private int smjer = 1;

    private boolean ukrcavanje = false;
    private boolean iskrcavanje = false;

    private final int[] izlazeNaStanici;
    private final int[][] cekaju;

    public Autobus(int kapacitet, int brojStanica) {
        if (kapacitet < 1 || brojStanica < 2) {
            throw new IllegalArgumentException(
                    "Potreban je pozitivan kapacitet i bar dvije stanice.");
        }

        this.kapacitet = kapacitet;
        this.brojStanica = brojStanica;

        izlazeNaStanici = new int[brojStanica + 1];
        cekaju = new int[brojStanica + 1][brojStanica + 1];
    }

    public synchronized void udji(int id, int polazna, int odrediste)
            throws InterruptedException {
        if (polazna < 1 || polazna > brojStanica
                || odrediste < 1 || odrediste > brojStanica
                || polazna == odrediste) {
            throw new IllegalArgumentException("Neispravne stanice.");
        }

        System.out.println("Gradjanin " + id + " ceka na stanici "
                + polazna + " za stanicu " + odrediste);

        cekaju[polazna][odrediste]++;

        try {
            while (!ukrcavanje
                    || trenutnaStanica != polazna
                    || brojPutnika == kapacitet
                    || (odrediste - polazna) * smjer <= 0) {
                wait();
            }

            brojPutnika++;
            izlazeNaStanici[odrediste]++;

            System.out.println("Gradjanin " + id
                    + " je usao na stanici " + polazna);
        } finally {
            cekaju[polazna][odrediste]--;
            notifyAll();
        }
    }

    public synchronized void izadji(int id, int odrediste)
            throws InterruptedException {
        while (!iskrcavanje || trenutnaStanica != odrediste) {
            wait();
        }

        brojPutnika--;
        izlazeNaStanici[odrediste]--;

        System.out.println("Gradjanin " + id
                + " je izasao na stanici " + odrediste);

        notifyAll();
    }

    // Poziva se dok nit autobusa drzi bravu ovog objekta.
    private boolean imaOdgovarajucihPutnika() {
        for (int odrediste = 1; odrediste <= brojStanica; odrediste++) {
            if ((odrediste - trenutnaStanica) * smjer > 0
                    && cekaju[trenutnaStanica][odrediste] > 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    System.out.println("Autobus je stigao na stanicu "
                            + trenutnaStanica);

                    // Prvo izlaze svi kojima je ovdje odrediste.
                    iskrcavanje = true;
                    notifyAll();

                    while (izlazeNaStanici[trenutnaStanica] > 0) {
                        wait();
                    }

                    iskrcavanje = false;

                    // Na krajnjim stanicama okrecemo smjer.
                    if (trenutnaStanica == brojStanica) {
                        smjer = -1;
                    } else if (trenutnaStanica == 1) {
                        smjer = 1;
                    }

                    // Zatim ulaze putnici kojima odgovara smjer.
                    ukrcavanje = true;
                    notifyAll();

                    while (brojPutnika < kapacitet
                            && imaOdgovarajucihPutnika()) {
                        wait();
                    }

                    ukrcavanje = false;

                    System.out.println("Autobus polazi sa stanice "
                            + trenutnaStanica + " sa "
                            + brojPutnika + " putnika.");
                }

                // Voznja do sljedece stanice je izvan brave.
                Thread.sleep(1000);

                synchronized (this) {
                    trenutnaStanica += smjer;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}