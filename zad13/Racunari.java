package zad13;

public class Racunari implements Runnable {
	private final int id;
	Stampac s;
	
	public Racunari(int id, Stampac s) {
		this.id = id;
		this.s = s;
	}
	
	@Override
	public void run() {
	    try {
	        Thread.sleep(
	            java.util.concurrent.ThreadLocalRandom.current()
	                .nextInt(100, 1001)
	        );
	        s.stampaj(id, "rijec");
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}

}
