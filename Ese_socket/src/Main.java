
public class Main {

	public static void main(String[] args) {
		/*
		 * Scrivere un socket server che si mette in ascolto sulla porta 32456, legge una riga di testo e la restituisce "rovesciata".
		 *  Es: lette Ciao e restituisce: oaiC
		 *  Il server deve essere multithreading .
		 */
		Rovescia srv = new Rovescia();
		srv.Server(32456);
	}

}
