package zad18;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;

        Rolerkoster rolerkoster = new Rolerkoster(k);
        Thread nitRolerkostera = new Thread(rolerkoster);

        nitRolerkostera.start();

        for (int i = 1; i <= n; i++) {
            Putnik putnik = new Putnik(i, rolerkoster);
            Thread nitPutnika = new Thread(putnik);
            nitPutnika.start();
        }
    }
}