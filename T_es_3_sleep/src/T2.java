
public class T2 extends Thread {
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
