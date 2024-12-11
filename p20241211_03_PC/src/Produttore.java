import java.util.*;


public class Produttore extends Thread {
	
		//Il primo thread genera ad intervalli casuali (variabili
		//    * tra 100 e 1000 ms) dei numeri interi 
		//  * casuali e li aggiunge in coda.
	public void run() {
		Random rng = new Random();
		while (true) {
			Main.qi.add(rng.nextInt(0,1000));
			try {
				Thread.sleep(rng.nextInt(100,1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
}}
