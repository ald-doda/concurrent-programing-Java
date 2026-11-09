package zad15;

import java.util.Random;
public class Agent implements Runnable {
	private final Smoker[] smokers;
	private final Random r = new Random();
	
	public Agent(Smoker[] smokers) {
		this.smokers = smokers;
	}
	@Override
	public synchronized void run() {
	    try {
	        while (true) {
	            int izabrani = r.nextInt(3);

	            System.out.println("Agent daje dozvolu pusacu " + izabrani);
	            smokers[izabrani].canSmoke = true;
	            notifyAll();

	            while (smokers[izabrani].canSmoke) {
	                wait();
	            }
	        }
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}

}
