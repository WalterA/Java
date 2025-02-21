class CasellaPosta {
	private final String[] casella;
    private int messaggiPresenti = 0;
    private static final int CAPACITA = 10;

    public CasellaPosta() {
        this.casella = new String[CAPACITA];
    }

    // Metodo per scrivere un messaggio nella casella
    public synchronized void scrivi(String messaggio) throws InterruptedException {
        // Aspetta finché la casella è piena
        while (messaggiPresenti == CAPACITA) {
            System.out.println("Casella piena, lo scrittore aspetta...");
            wait(); // Il thread si ferma qui finché non c'è spazio
        }

        // Scrive il messaggio nella casella
        casella[messaggiPresenti] = messaggio;
        messaggiPresenti++;
        System.out.println("Scrittore ha scritto: " + messaggio);
        notifyAll(); // Risveglia il Lettore, se c'è uno in attesa
    }

    // Metodo per leggere un messaggio dalla casella
    public synchronized String leggi() throws InterruptedException {
        // Aspetta finché la casella è vuota
        while (messaggiPresenti == 0) {
            System.out.println("Casella vuota, il lettore aspetta...");
            wait(); // Il thread si ferma qui finché non ci sono messaggi
        }

        // Legge il messaggio dalla casella
        messaggiPresenti--;
        String messaggio = casella[messaggiPresenti];
        System.out.println("Lettore ha letto: " + messaggio);
        notifyAll(); // Risveglia lo Scrittore, se c'è uno in attesa
        return messaggio;
    }
}
