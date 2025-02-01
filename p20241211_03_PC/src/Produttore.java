import java.util.Random;

public class Produttore extends Thread {

	public void run() {
//		Il primo
//		 * thread genera ad intervalli casuali (variabili tra 100 e 1000 ms) dei numeri
//		 * interi casuali e li aggiunge in coda		
		Random rng = new Random();
		while (true) {
			Main.coda.add(rng.nextInt(0, 1000));
			try {
				Thread.sleep(rng.nextInt(100, 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
