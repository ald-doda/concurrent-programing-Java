package zad19;

public class Most {
    private boolean zelenoLijevo = true;
    private int brojNaMostu = 0;
    private boolean promjenaUToku = false;

    public synchronized void udji(int id, boolean saLijeve)
            throws InterruptedException {

        while (promjenaUToku || saLijeve != zelenoLijevo) {
            System.out.println("Automobil " + id + " ceka na ulazak.");
            wait();
        }

        brojNaMostu++;
        System.out.println("Automobil " + id + " prelazi "
                + (saLijeve ? "slijeva nadesno." : "zdesna nalijevo."));
    }

    public synchronized void izadji(int id) {
        brojNaMostu--;
        System.out.println("Automobil " + id + " je napustio most.");

        if (brojNaMostu == 0) {
            notifyAll();
        }
    }

    public synchronized void promijeniSmjer()
            throws InterruptedException {

        promjenaUToku = true;

        try {
            while (brojNaMostu > 0) {
                wait();
            }

            zelenoLijevo = !zelenoLijevo;
            System.out.println("Zeleno je "
                    + (zelenoLijevo ? "lijevo." : "desno."));
        } finally {
            promjenaUToku = false;
            notifyAll();
        }
    }
}