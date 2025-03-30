package Main;
//Una classe di test in cui uno o due clienti registrano il proprio nome
//e acquistano  uno o più prodotti. Stampare la lista dei prodotti acquistati.

import Entity.*;
import Utility.Funzioni;

public class Test {

	public static void main(String[] args) {
		Negozio n1 = new Negozio("Nemo");
		Negozio n2 = new Negozio("Tirreno");
		Negozio n3 = new Negozio("N3");
		Negozio n4 = new Negozio("N4");
		Tv t1 = new Tv(1, "Samsung", "ok", 142.52, 50, true);
		Lavatrice l1 = new Lavatrice(1, "Lava", "tri", 145.54, 50);
		Tv t2 = new Tv(2, "Sam", "ok", 142.52, 50, true);
		Lavatrice l2 = new Lavatrice(2, "Lavatrice", "tri", 145.54, 50);
		Cliente c1 = new Cliente(1, "FIli", "Costa", "dadsa", "sadsa");
		Cliente c2 = new Cliente(2, "FIlipponi", "Costa", "dadsa", "sadsa");
		
		
		
		Funzioni f = new Funzioni();
		System.out.println(f.InsertN(t2, n2));
		System.out.println(f.InsertN(t1, n2));
		System.out.println(f.InsertN(l2, n2));
		System.out.println(f.InsertN(l1, n1));
		System.out.println(f.InsertP(c2, n1,t1));
		System.out.println(f.InsertP(c1, n2,t2));
		System.out.println(f.InsertP(c2, n1,l1));
		System.out.println(f.InsertP(c1, n2,l2));
		f.Getprodotti(c2);
		f.Getprodotti(c1);
	

	}

}
