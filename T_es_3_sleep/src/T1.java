
public class T1 extends Thread {
	// Creare due classi thread che stampano
	// 5 numeri ciascuno con un ritardo di 1 secondo. Lanciare due thread
	public void run() {
		int durata = 1000;
		for (int i = 0; i < 6; i++) {
			System.out.println(i);
			try {
				sleep(durata);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
