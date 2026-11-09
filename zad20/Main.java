package zad20;

public class Main {
    public static void main(String[] args) {
        int brojGradjana = 10;
        int brojStanica = 5;
        int kapacitet = 3;

        Autobus autobus = new Autobus(kapacitet, brojStanica);

        for (int i = 1; i <= brojGradjana; i++) {
            Gradjanin gradjanin =
                    new Gradjanin(i, autobus, brojStanica);

            new Thread(gradjanin).start();
        }

        new Thread(autobus).start();
    }
}