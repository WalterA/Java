import java.util.*;

public class Main {

	public static void main(String[] args) {
		Balena b1 = new Balena(5, 140000, 2, 5, "Piscina");
		Balena b2 = new Balena(4, 100, 0, 50, "Piscina");
		Leopardo l1 = new Leopardo(45, 75, 88, 12, 10);
		Leopardo l2 = new Leopardo(45, 75, 88, 12, 150);

		LinkedList<Balena> lb = new LinkedList<Balena>();
		lb.add(b1);
		lb.add(b2);

		LinkedList<Leopardo> ll = new LinkedList<Leopardo>();
		ll.add(l2);
		ll.add(l1);
		
		LinkedList<Mammifero> lm = new LinkedList<Mammifero>();
		lm.add(l1);
		lm.add(l2);
		lm.add(b1);
		lm.add(b2);
		Collections.shuffle(lm);
		//var gigi = lm.getClass();
		//System.out.println(gigi);
		
	}

}
