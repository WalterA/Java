import java.util.Random;

public class Consumatore extends Thread {
	public void run() {
//		Il secondo thread legge i numeri
//		 * presenti in coda, a intervalli casuali compresi tra 100 e 500 ms), ne
//		 * calcola somma e valor medio e li stampa ogni 2 secondi.
		Random rng = new Random();
		Integer somma = 0;
		Integer tempo = 0;
		Integer quanti = 0;

		while (true) {
			//attendo da 100 a 500 ms
			int attesa = rng.nextInt(100, 500);
			tempo += attesa;
			try {
				Thread.sleep(attesa);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tempo >= 2000) {
				System.out.println("Letti finora " + quanti + " numeri.");
				if (quanti > 0) {
					System.out.println("Somma: " + somma + ". Media: " + somma*1.0/quanti);
				}
				tempo = 0; //reset del tempo di attesa
			}
			//leggo da coda, se qualcosa è presente
			while (!Main.coda.isEmpty()) {
				Integer num = Main.coda.poll();
				quanti++;
				somma += num;
			}
		}
	}
}

