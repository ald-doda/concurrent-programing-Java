package zadatak6;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		int n = r.nextInt(1, 50);
		int niz[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			niz[i] = r.nextInt(-10, 11);
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
		ArrayThread n1 = new ArrayThread(niz, 0, n/3);
		ArrayThread n2 = new ArrayThread(niz, n/3, 2*n/3);
		ArrayThread n3 = new ArrayThread(niz, 2*n/3, n);
		
		Thread t1 = new Thread(n1);
		Thread t2 = new Thread(n2);
		Thread t3 = new Thread(n3);
		
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		int[] pozicija = {0, n / 3, 2 * n / 3};
		int[] kraj = {n / 3, 2 * n / 3, n};
		int[] sortirani = new int[n];

		for (int i = 0; i < n; i++) {
		    int izabrani = -1;

		    for (int dio = 0; dio < 3; dio++) {
		        if (pozicija[dio] == kraj[dio]) {
		            continue;
		        }

		        if (izabrani == -1 || niz[pozicija[dio]] < niz[pozicija[izabrani]]) {
		            izabrani = dio;
		        }
		    }

		    sortirani[i] = niz[pozicija[izabrani]];
		    pozicija[izabrani]++;
		}
		
		for (int i = 0; i < n; i++) {
		    System.out.print(sortirani[i] + " ");
		}
		System.out.println();

	}

}
