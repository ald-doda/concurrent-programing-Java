package zad08;
import java.util.Random;
public class Clan implements Runnable {
	Random r = new Random();
	String id;
	Racun ra;
	
	public Clan(String i, Racun ra) {
		this.id = i;
		this.ra = ra;
	}
	@Override
	public void run() {
		    int iznos = r.nextInt(5, 501);

		    if (r.nextBoolean()) {
		        try {
					ra.uplati(id, iznos);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } else {
		        try {
					ra.podigni(id, iznos);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		
	}

}
