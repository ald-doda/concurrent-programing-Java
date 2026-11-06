package zadatak1;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Random r = new Random();
		n = 10;
		Thread[] niti = new Thread[n];

		for (int i = 0; i < n; i++) {
		    niti[i] = new Thread(new MyThread(i));
		    niti[i].start();
		}

		System.out.println("Main je pokrenut");
	}

}
