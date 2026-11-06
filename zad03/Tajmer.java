package zadatak3;

public class Tajmer implements Runnable {
	Generator g;
	public Tajmer(Generator g) {
		this.g = g;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			g.flag = true;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
