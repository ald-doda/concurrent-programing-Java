package zadatak3;
import java.util.Random;
public class Generator implements Runnable{
	Random r = new Random();
	public volatile boolean flag = false;
	
	public Generator(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		while(!flag == true) {
			System.out.println(r.nextInt(1, 1001));
			
		}
	}

}
