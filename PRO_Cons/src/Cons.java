import java.util.List;

class Cons implements Runnable {
    private final List<Integer> bufferCondiviso;

    public Cons(List<Integer> bufferCondiviso) {
        this.bufferCondiviso = bufferCondiviso;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume();
                Thread.sleep(700); // Simula un ritardo nel consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrotto.");
        }
    }

    private void consume() throws InterruptedException {
        synchronized (bufferCondiviso) {
            while (bufferCondiviso.isEmpty()) {
                System.out.println("Il buffer è vuoto, il thread Consumer resta in attesa... la dimensione del buffer adesso è: " + bufferCondiviso.size());
                bufferCondiviso.wait();
            }

            int removedItem = bufferCondiviso.remove(0); // Rimuove il primo elemento
            System.out.println("Il thread Consumer ha eliminato l'elemento: " + removedItem + " la dimensione del buffer adesso è: " + bufferCondiviso.size());
            bufferCondiviso.notifyAll(); // Notifica al producer
        }
    }
}
