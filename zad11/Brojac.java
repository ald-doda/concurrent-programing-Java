package zad11;

public class Brojac implements Runnable {
	Generator g;
	public volatile int br = 0;
	
	public Brojac(Generator g) {
	    this.g = g;
	}
	
	public boolean savrsen(int broj) {
		if (broj < 2) {
		    return false;
		}
		int sum = 0;
		for(int i = 1; i < broj; i++) {
			if(broj % i == 0) {
				sum += i;
			}
		}
		
		if(sum == broj) return true;
		else return false;
	}
	
	@Override
	public void run() {
		System.out.println("Pocinje brojanje savrsenih....");
		int niz[] = g.getNiz();
		for(int i = 0; i < niz.length; i++) {
			if(savrsen(niz[i])) br++;
			
		}
		try {
			Thread.sleep(300);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Savrseni brojevi su izbrojani...");
	}
	
	
	public int getBr() {
		return br;
	}

}
