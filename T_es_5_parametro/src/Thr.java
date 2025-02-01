
public class Thr extends Thread {
	char ch;
	int i = 1, j = 100;

	public Thr(char c) {
		ch = c;
	}

	public void run() {

		if (ch == 'A')
			while (true) {
				System.out.println(" A = " + i);
				i++;
				try {
					this.sleep(500);
				} catch (InterruptedException e) {
				}
				if (i > 10)
					break;
			}
		else
			while (true) {
				System.out.println(" B = " + j);
				j--;
				try {
					this.sleep(500);
				} catch (InterruptedException e) {
				}
				if (j < 90)
					break;
			}
	}
}
