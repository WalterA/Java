/*
 * Simulare una casella di posta.

Un thread scrive dei messaggi in una casella di posta che può contenere al massimo 10 messaggi
 e si ferma quando la casella è piena. Riprende a scrivere messaggi quando almeno un messaggio viene letto.
Un thread legge i messaggi dalla casella di posta è si ferma quando la casella è vuota.
 Riprende a leggere i messaggi quando la casella contiene almeno un messaggio.
Creare una classe che scrive i messaggi, una classe che legge i messaggi e
 una classe di test che attiva i due thread.
 */
public class Main {

	public static void main(String[] args) {
		 CasellaPosta casellaPosta = new CasellaPosta();

	        // Crea i thread Scrittore e Lettore
	        Scrittore scrittore = new Scrittore(casellaPosta);
	        Lettore lettore = new Lettore(casellaPosta);

	        // Avvia i thread
	        scrittore.start();
	        lettore.start();
	    }

}
