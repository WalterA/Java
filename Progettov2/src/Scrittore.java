class Scrittore extends Thread {
	 private final CasellaPosta casellaPosta;

	    public Scrittore(CasellaPosta casellaPosta) {
	        this.casellaPosta = casellaPosta;
	    }

	    @Override
	    public void run() {
	    	int i = 1;
	        try {
	        	 while (true) {
	                casellaPosta.scrivi("Messaggio " + i++); // Scrive il messaggio
	                Thread.sleep(1000); // Simula il tempo di scrittura
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}