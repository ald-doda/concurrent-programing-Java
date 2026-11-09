package zad07;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] a = {
            {2, 3, 4},
            {5, 6, 7},
            {8, 9, 1}
        };

        int[][] b = {
            {3, 1},
            {3, 1},
            {3, 1}
        };

        int m = a.length;
        int k = b.length;
        int n = b[0].length;

        int[][] rezultat = new int[m][n];
        SkalarniProizvod[][] poslovi = new SkalarniProizvod[m][n];
        Thread[][] niti = new Thread[m][n];

        // Pravimo kopije reda i kolone i pokrećemo sve niti.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] red = a[i].clone();
                int[] kolona = new int[k];

                for (int indeks = 0; indeks < k; indeks++) {
                    kolona[indeks] = b[indeks][j];
                }

                poslovi[i][j] = new SkalarniProizvod(red, kolona);
                niti[i][j] = new Thread(poslovi[i][j]);
                niti[i][j].start();
            }
        }

        // Čekamo rezultate i upisujemo ih u odgovarajuće ćelije.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                niti[i][j].join();
                rezultat[i][j] = poslovi[i][j].getResult();
            }
        }

        System.out.println("Matrica proizvoda:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rezultat[i][j] + " ");
            }
            System.out.println();
        }
    }
}