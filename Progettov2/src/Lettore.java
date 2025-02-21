class Lettore extends Thread {
	 private final CasellaPosta casellaPosta;

	    public Lettore(CasellaPosta casellaPosta) {
	        this.casellaPosta = casellaPosta;
	    }

	    @Override
	    public void run() {
	        try {
	            while (true) {
	                casellaPosta.leggi(); // Legge un messaggio
	                Thread.sleep(1500); // Simula il tempo di lettura
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}
