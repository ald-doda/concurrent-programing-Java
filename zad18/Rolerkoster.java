package zad18;

public class Rolerkoster implements Runnable {
    private final int kapacitet;
    private int brojPutnika = 0;
    private boolean ukrcavanje = true;
    private boolean voznjaZavrsena = false;

    public Rolerkoster(int kapacitet) {
        this.kapacitet = kapacitet;
    }
    
    public synchronized void udji(int id) throws InterruptedException {
        while (!ukrcavanje || brojPutnika == kapacitet) {
            System.out.println("Putnik " + id + " ceka ukrcavanje.");
            wait();
        }

        brojPutnika++;
        System.out.println("Putnik " + id + " se ukrcao.");

        if (brojPutnika == kapacitet) {
            ukrcavanje = false;
            notifyAll();
        }
    }
    
    public synchronized void izadji(int id) throws InterruptedException {
        while (!voznjaZavrsena) {
            wait();
        }

        brojPutnika--;
        System.out.println("Putnik " + id + " se iskrcao.");

        if (brojPutnika == 0) {
            voznjaZavrsena = false;
            ukrcavanje = true;
            notifyAll();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (brojPutnika < kapacitet) {
                        wait();
                    }

                    System.out.println("Voznja pocinje!");
                }

                Thread.sleep(1000);

                synchronized (this) {
                    System.out.println("Voznja je zavrsena!");
                    voznjaZavrsena = true;
                    notifyAll();

                    while (voznjaZavrsena) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}