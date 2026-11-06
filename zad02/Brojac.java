package zadatak2;
import java.util.Random;
public class Brojac implements Runnable {
	Random r = new Random();
	public volatile int i = 0;
	public volatile boolean flag = false;
	
	@Override
	public void run() {
		while(!flag == true) {
			i++;
			try {
				Thread.sleep(r.nextInt(1, 100+1));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	

}
