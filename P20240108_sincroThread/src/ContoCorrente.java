import java.io.*;

public class ContoCorrente {
    private final String filePath = "db.txt";

    // Metodo per ottenere il saldo dal file
    public double getSaldo() {
        double saldo = 0;
        BufferedReader br = null;

        try {
            File fin = new File(new File(".").getCanonicalPath() + File.separator + filePath);
            br = new BufferedReader(new FileReader(fin));
            String line = br.readLine();
            if (line != null) {
                saldo = Double.parseDouble(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return saldo;
    }

    // Metodo synchronized per il prelievo
    public synchronized boolean prelievo(double somma) {
        double saldo = getSaldo();
        if (saldo >= somma) {
            saldo -= somma;
            salvaSaldo(saldo);
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + somma + ". Saldo residuo: " + saldo);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " non ha potuto prelevare. Saldo insufficiente.");
            return false;
        }
    }

    // Metodo non synchronized per il prelievo
    public boolean prelievoNonSync(double somma) {
        double saldo = getSaldo();
        if (saldo >= somma) {
            saldo -= somma;
            salvaSaldo(saldo);
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + somma + ". Saldo residuo: " + saldo);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " non ha potuto prelevare. Saldo insufficiente.");
            return false;
        }
    }

    // Metodo per salvare il nuovo saldo nel file
    private void salvaSaldo(double saldo) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(Double.toString(saldo));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
