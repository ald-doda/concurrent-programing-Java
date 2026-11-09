package zad13;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Stampac s = new Stampac();
		int n = 5;
		Thread[] niti = new Thread[n];

		for (int i = 0; i < n; i++) {
		    Racunari r = new Racunari(i, s);
		    niti[i] = new Thread(r);
		    niti[i].start();
		}

		for (int i = 0; i < n; i++) {
		    niti[i].join();
		}

	}

}
