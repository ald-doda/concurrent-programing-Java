package zad10;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int kapacitet = 2;
        int brojPotrosaca = 3;

        Bafer bafer = new Bafer(kapacitet, brojPotrosaca);

        Proizvodjac proizvodjac = new Proizvodjac(bafer);
        Thread nitProizvodjaca = new Thread(proizvodjac);

        Thread[] nitiPotrosaca = new Thread[brojPotrosaca];

        for (int i = 0; i < brojPotrosaca; i++) {
            Potrosaci potrosac = new Potrosaci(i, bafer);
            nitiPotrosaca[i] = new Thread(potrosac);
        }

        nitProizvodjaca.start();

        for (int i = 0; i < brojPotrosaca; i++) {
            nitiPotrosaca[i].start();
        }

        nitProizvodjaca.join();

        for (int i = 0; i < brojPotrosaca; i++) {
            nitiPotrosaca[i].join();
        }

        System.out.println("Svi proizvodi su preuzeti.");
    }
}