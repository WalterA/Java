/**
 * 
 */

import java.nio.BufferOverflowException;
import java.nio.channels.OverlappingFileLockException;
import java.util.*;

/**
 * La classe Main è la classe Main del progetto
 * La utilizzo come prova di documentazione
 * eh, eh, eh
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int a,b,c=0;
		
		Boolean doIt = false; 
		
		while (doIt) {
			
			System.out.print("a: ");
			a=sc.nextInt();
			System.out.print("b: ");
			b=sc.nextInt();
			
			try {
				c=Calcola(a, b);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("C: " + c);
		}
		
		//dichiariamo un set di interi
		Set<Integer> si1 = new TreeSet<Integer>();
		Set<Integer> si2 = new HashSet<Integer>();
		
		for (Integer i: si1) {
			//enumero gli elementi del set
		}
		
		//Supponiamo di avere due liste di interi
		LinkedList<Integer> li1 = new LinkedList<Integer>();
		LinkedList<Integer> li2 = new LinkedList<Integer>();
		Random rnd = new Random();
		
		for (int i=0; i<4; i++) {
			li1.add(rnd.nextInt(0, 100));
			li2.add(rnd.nextInt(0, 100));
		}
		
		System.out.println(li1);
		System.out.println(li2);
		
		//Voglio stampare in modo accoppiato il primo elemento della prima lista
		//e il primo elemento della seconda lista
		//il secondo elemento della prima e il secondo elemento della seconda
		//e così via
		for (int i=0; i<li1.size(); i++) {
			System.out.println(li1.get(i) + ", " + li2.get(i));
		}
		
		Iterator<Integer> ili1 = li1.iterator();
		Iterator<Integer> ili2 = li2.iterator();
		
		while (ili1.hasNext() && ili2.hasNext()) {
			System.out.println(ili1.next() + ", " + ili2.next());
		}
		
		//Mappe
		TreeMap<Integer, String> tmis = new TreeMap<Integer, String>();
		TreeMap<String, Persona> tmps = new TreeMap<String, Main.Persona>();
		TreeMap<Persona, Auto> tm		
	}

	private static int Calcola(int a, int b) throws Exception {
		try {
			return (a / b);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Eccezione eccezionale");
		} finally {
			System.out.println("Io sono la finally");
		}
		//return (0);
	}
	class Persona {
		public Persona(String a , String b) {
			a=
		}
		public String n;
		public String c;
	}

}
