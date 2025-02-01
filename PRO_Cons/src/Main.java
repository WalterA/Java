import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> bufferCondiviso = new LinkedList<>();
		int size = 4;

		Thread prodThread = new Thread(new Pro_1(bufferCondiviso, size), "Producer1");
		Thread prodThread2 = new Thread(new Pro_2(bufferCondiviso, size), "Producer2");
		Thread consThread = new Thread(new Cons(bufferCondiviso), "Consumer");

		prodThread.start();
		prodThread2.start();
		consThread.start();
	}

}
