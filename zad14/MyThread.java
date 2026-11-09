package zad14;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {
	private final int id;
	private CyclicBarrier barrier;
	
	public MyThread(int id, CyclicBarrier barrier) {
		this.id = id;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(id + ": Dosla sam na barijeru, cekam ostale...");
			try {
				barrier.await();
			} catch(InterruptedException | BrokenBarrierException e) {
				throw new RuntimeException(e);
			}
			System.out.println(id + ": Napustam barijeru...");
			
			try {
				barrier.await();
				
			} catch(InterruptedException | BrokenBarrierException e) {
				throw new RuntimeException(e);
			}
		}
		
	}

}
