package zad13;

import java.io.FileWriter;
import java.io.IOException;

public class Stampac {
	public boolean zauzet = true;
	
	
	public synchronized void stampaj(int id, String rijec) {
	    try (FileWriter pisac = new FileWriter("stampa.txt", true)) {
	        pisac.write(rijec + System.lineSeparator());
	        System.out.println("Racunar " + id + " je odstampao: " + rijec);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
