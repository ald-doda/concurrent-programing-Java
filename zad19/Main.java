package zad19;

public class Main {
    public static void main(String[] args) {
        Most most = new Most();

        for (int i = 0; i < 6; i++) {
            boolean saLijeve = i % 2 == 0;
            Automobil automobil = new Automobil(i, most, saLijeve);
            new Thread(automobil).start();
        }

        new Thread(new Semafor(most)).start();
    }
}