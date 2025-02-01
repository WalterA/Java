import java.util.*;

public class Main {

	public static void main(String[] args) {
		Random rng = new Random();
		Queue<Integer> qi = new LinkedList<Integer>();
		qi.add(9);
		qi.add(8);
		qi.add(11);
		qi.add(3);
		System.out.println(qi);
		System.out.println(qi.poll());
		Integer primo = qi.poll();
		System.out.println(primo);
		while (rng.nextInt(0,100)>1) {
			qi.add(rng.nextInt(0,1000));
		}
		//come faccio a stampare la coda un elemento per volta e conteporaneamente a togliere gli elementi stampati?
		while(!qi.isEmpty()) {
			System.out.println(qi.poll());
		}
		while (rng.nextInt(0,100)>60) {
			qi.add(rng.nextInt(0,1000));
		}
		//per scandire una collezione
		for( var x:qi) {
			System.out.println(x);
		}
		Iterator it  = qi.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//Esempio con streams e lambda funtions
		//qi.stream().forEach(x->System.out.println(x));
		System.out.println(Vai(10));
		Stack<Integer> si = new Stack<Integer>();
		si.push(100);
		si.push(110);
		si.push(20);
		si.push(30);
		System.out.println(si.pop());
		
		
		
	}

	private static double Vai(int i) {
		double b = ok(i);
		System.out.println(b);
		return b;
		
	}

	private static double ok(int i) {
		Double a = Math.pow(i,22);
		return a;
	}

}
