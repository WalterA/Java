import java.util.*;

public class Main {
	public static void main(String[] args) {
		/*
		 * ho essenzialmente due tipi di liste LinkedList, ArreyList
		 */
		LinkedList<Integer> li;
		li = new LinkedList<Integer>();
		// appendi in fondo
		li.add(7);
		li.add(2);
		li.add(70);
		li.add(30);
		System.out.println(li);

		// primo elemento della lista
		System.out.println(li.getFirst());
		// ultimo elemento
		System.out.println(li.getLast());
		// indice
		System.out.println(li.get(2));
		for (Integer i : li) {
			System.out.println(i + " ");
		}
		System.out.println();
		// ora vorrei stampare al contratio
		Collections.reverse(li);
		System.out.println(li);
		// Disordinare
		Collections.shuffle(li);
		System.out.println(li);
		// ordinare
		Collections.sort(li);
		System.out.println(li);

		Citta roma = new Citta("roma", 0.0, 0.0, 3578922);
		LinkedList<Citta> lc = new LinkedList<Citta>();
		lc.add(roma);
		lc.add(new Citta("milano", 0.1, 0.2, 14551));
		lc.add(new Citta("firenze", 0.2, 0.3, 58987545));
		System.out.println(lc);
		Collections.sort(lc);
		System.out.println(lc);
		Collections.shuffle(lc);

		lc.sort(new Comparator<Citta>() {
			@Override
			public int compare(Citta o1, Citta o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		Pair<String> ps = new Pair<String>("uno", "due");
		Pair<Integer> pi = new Pair<Integer>(1, 2);
		var l3int = CreaLista(10, 20, 30);
		var l3str = CreaLista("uno", "due", "tre");
		System.out.println(l3int);

	}

	public static <T> List<T> CreaLista(T i1, T i2, T i3) {
		LinkedList<T> li = new LinkedList<T>();
		li.add(i1);
		li.add(i2);
		li.add(i3);
		return li;
	}

}
