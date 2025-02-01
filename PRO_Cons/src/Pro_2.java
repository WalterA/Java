import java.util.LinkedList;
import java.util.List;

public class Pro_2 implements Runnable {
	private final List<Integer> bufferCondiviso;
    private final int SIZE;
    private int i = 0; // Contatore per gli elementi da produrre

    public Pro_2(List<Integer> bufferCondiviso, int size) {
        this.bufferCondiviso = bufferCondiviso;
        this.SIZE = size;
    }

    @Override
    public void run() {
        try {
            while (true) {
                produce();
                Thread.sleep(1000); // Simula un ritardo nella produzione
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrotto.");
        }
    }

    private void produce() throws InterruptedException {
        synchronized (bufferCondiviso) {
            while (bufferCondiviso.size() == SIZE) {
                System.out.println("Il buffer è pieno, il thread Producer resta in attesa... la dimensione del buffer adesso è: " + bufferCondiviso.size());
                bufferCondiviso.wait();
            }

            bufferCondiviso.add(++i); // Aggiunge un nuovo elemento al buffer
            System.out.println("Il thread Producer ha aggiunto al buffer l'elemento: " + i + " la dimensione del buffer adesso è: " + bufferCondiviso.size());
            bufferCondiviso.notifyAll(); // Notifica al consumer
        }
    }
}