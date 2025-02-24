class Lettore extends Thread {
	private final CasellaPosta casellaPosta;

	public Lettore(CasellaPosta casellaPosta) {
		this.casellaPosta = casellaPosta;
	}

	@Override
	public void run() {
		try {
			while (true) {
				casellaPosta.leggi();
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
