/*
 * Simulare una casella di posta.
Creare una classe che scrive i messaggi, una classe che legge i messaggi e
 una classe di test che attiva i due thread.
 */
public class Main {

	public static void main(String[] args) {
		CasellaPosta casellaPosta = new CasellaPosta();

		Scrittore scrittore = new Scrittore(casellaPosta);
		Lettore lettore = new Lettore(casellaPosta);

		scrittore.start();
		lettore.start();
	}

}
