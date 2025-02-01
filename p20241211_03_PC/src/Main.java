import java.util.*;

public class Main {

	public static void main(String[] args) {
		/*
		 * Realizzare un programma con due thread, un thread produttore e un thread
		 * consumatore i due thread condividono una coda di numeri casuali. Il primo
		 * thread genera ad intervalli casuali (variabili tra 100 e 1000 ms) dei numeri
		 * interi casuali e li aggiunge in coda. Il secondo thread legge i numeri
		 * presenti in coda, a intervalli casuali compresi tra 100 e 500 ms), ne
		 * calcola somma e valor medio e li stampa ogni 2 secondi. Quindi il secondo
		 * thread legge a intervalli casuali e quando la somma di questi intervalli
		 * (cioè il tempo trascorso) ha superato i due secondi, stampa somma e media.
		 * NB: Questo implica il fatto che il secondo thread tra una lettura e l'altra
		 * accumula i valori di somma e media NB: la media è la somma/numero di elementi
		 * letti. Quindi non dovete ricordare la somma e la media ma dovete ricordare la
		 * somma e il numero di elementi letti. Attenzione: Il programma non deve
		 * terminare mai.
		 */
		
		//Implementazione
		//Dichiazione della coda
		//Dichiarazione dei metodi di accesso alla coda
		//dichiarazione dei due thread
		//start dei due thread
		//Thread.sleep(100);

		Produttore pr = new Produttore();
		Consumatore co = new Consumatore();
		
		pr.start();
		co.start();
		
		//Finchè c'è un thread in esecuzione, java non termina!
	}

	public static Queue<Integer> coda = new LinkedList<Integer>();
}
