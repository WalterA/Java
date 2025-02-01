import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calcolatrice {

    private static final Logger logger = Logger.getLogger(Calcolatrice.class.getName());

    static {
        // Configurazione del logger
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL); // Mostra tutti i livelli di log
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        logger.setLevel(Level.ALL); // Imposta il livello del logger
        logger.setUseParentHandlers(false); // Evita la duplicazione di log
    }

    public double somma(double a, double b) {
        logger.log(Level.INFO, "Eseguendo la somma: {0} + {1}", new Object[]{a, b});
        double risultato = a + b;
        logger.log(Level.FINE, "Risultato della somma: {0}", new Object[]{risultato});
        return risultato;
    }

    public double sottrazione(double a, double b) {
        logger.log(Level.INFO, "Eseguendo la sottrazione: {0} - {1}", new Object[]{a, b});
        double risultato = a - b;
        logger.log(Level.FINE, "Risultato della sottrazione: {0}", new Object[]{risultato});
        return risultato;
    }

    public double moltiplicazione(double a, double b) {
        logger.log(Level.INFO, "Eseguendo la moltiplicazione: {0} * {1}", new Object[]{a, b});
        double risultato = a * b;
        logger.log(Level.FINE, "Risultato della moltiplicazione: {0}", new Object[]{risultato});
        return risultato;
    }

    public double divisione(double a, double b) {
        if (b == 0) {
            logger.log(Level.SEVERE, "Errore: Divisione per zero. Operandi: {0}, {1}", new Object[]{a, b});
            throw new ArithmeticException("Non è possibile dividere per zero.");
        }
        logger.log(Level.INFO, "Eseguendo la divisione: {0} / {1}", new Object[]{a, b});
        double risultato = a / b;
        logger.log(Level.FINE, "Risultato della divisione: {0}", new Object[]{risultato});
        return risultato;
    }

    public static void main(String[] args) {
        Calcolatrice calcolatrice = new Calcolatrice();

        try {
            calcolatrice.somma(5, 3);
            calcolatrice.sottrazione(10, 4);
            calcolatrice.moltiplicazione(2, 6);
            calcolatrice.divisione(12, 4);
            calcolatrice.divisione(10, 0); // Test divisione per zero
        } catch (Exception e) {
            logger.log(Level.WARNING, "Eccezione catturata: {0}", e.getMessage());
        }
    }
}
