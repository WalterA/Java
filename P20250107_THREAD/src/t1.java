
public class t1 extends Thread {
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Thread" + Thread.class.getSimpleName() + i);
		}

	}

}
