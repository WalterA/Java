//Un thread scrive dei messaggi in una casella di posta che può contenere al massimo 10 messaggi
//e si ferma quando la casella è piena. Riprende a scrivere messaggi quando almeno un messaggio viene letto.
//Un thread legge i messaggi dalla casella di posta è si ferma quando la casella è vuota.
//Riprende a leggere i messaggi quando la casella contiene almeno un messaggio.
class CasellaPosta {
	private final String[] casella;
	private int messaggiPresenti = 0;
	private static final int CAPACITA = 10;

	public CasellaPosta() {
		this.casella = new String[CAPACITA];
	}

	public synchronized void scrivi(String messaggio) throws InterruptedException {

		while (messaggiPresenti == CAPACITA) {
			System.out.println("Casella piena, lo scrittore aspetta...");
			wait();
		}

		casella[messaggiPresenti] = messaggio;
		messaggiPresenti++;
		System.out.println("Scrittore ha scritto: " + messaggio);
		notifyAll();
	}

	public synchronized String leggi() throws InterruptedException {

		while (messaggiPresenti == 0) {
			System.out.println("Casella vuota, il lettore aspetta...");
			wait();
		}

		messaggiPresenti--;
		String messaggio = casella[messaggiPresenti];
		System.out.println("Lettore ha letto: " + messaggio);
		notifyAll();
		return messaggio;
	}
}
