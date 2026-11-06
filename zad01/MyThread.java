package zadatak1;

public class MyThread implements Runnable {
	private final int id;
	
	public MyThread(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		long pocetak = System.currentTimeMillis();
		
		for(int i = 1; i <= 1_000_000_000; i++) {
			if(i % 1_000_000 == 0) {
			try {
				Thread.sleep(2);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		}
		long kr = System.currentTimeMillis() - pocetak;
		System.out.println("Nit " + id + " je zavrsila za : " + kr + " milisekundi...");
	}

}
