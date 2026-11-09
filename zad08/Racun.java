package zad08;

public class Racun {
	private volatile int stanje = 10000;
	

	
	public synchronized void uplati(String ime, int iznos) throws InterruptedException{
		stanje += iznos;
		System.out.println("Klijent " + ime + " je uplatio " + iznos + " , stanje na racunu je: "+ stanje);
		
	}
	public synchronized void podigni(String ime, int iznos) throws InterruptedException{
		if(stanje < iznos) {
			System.out.println("Nedovoljno sredstava za podizanje...");
			return;
		}
		else {
			stanje -= iznos;
			System.out.println("Klijent " + ime + " je podigao " + iznos + ", stanje na racunu je: " + stanje);
		}
	}
	
	
}
