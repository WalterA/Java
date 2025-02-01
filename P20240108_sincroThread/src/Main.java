import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Inizializza il saldo iniziale nel file
        inizializzaSaldo(100);

        ContoCorrente conto = new ContoCorrente();

        // Esempio con ClienteNonSync
        ClienteNonSync c1 = new ClienteNonSync("Mario", 70, conto);
        ClienteNonSync c2 = new ClienteNonSync("Lucia", 50, conto);

        System.out.println("Esecuzione senza synchronized:");
        c1.start();
        c2.start();
        c1.join();
        c2.join();

        // Reinizializza il saldo
        inizializzaSaldo(100);

        // Esempio con ClienteSync
        ClienteSync c3 = new ClienteSync("Mario", 70, conto);
        ClienteSync c4 = new ClienteSync("Lucia", 50, conto);

        System.out.println("Esecuzione con synchronized:");
        c3.start();
        c4.start();
        c3.join();
        c4.join();
    }

    private static void inizializzaSaldo(double saldoIniziale) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("db.txt"))) {
            bw.write(Double.toString(saldoIniziale));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
