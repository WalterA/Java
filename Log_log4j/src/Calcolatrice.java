import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calcolatrice {

    private static final Logger logger = LogManager.getLogger(Calcolatrice.class);

    // Metodo per la somma
    public double somma(double a, double b) {
        double risultato = a + b;
        logger.info("Eseguita somma: {} + {} = {}", a, b, risultato);
        return risultato;
    }

    // Metodo per la sottrazione
    public double sottrazione(double a, double b) {
        double risultato = a - b;
        logger.info("Eseguita sottrazione: {} - {} = {}", a, b, risultato);
        return risultato;
    }

    // Metodo per la moltiplicazione
    public double moltiplicazione(double a, double b) {
        double risultato = a * b;
        logger.info("Eseguita moltiplicazione: {} * {} = {}", a, b, risultato);
        return risultato;
    }

    // Metodo per la divisione
    public double divisione(double a, double b) {
        if (b == 0) {
            logger.error("Errore: divisione per zero (a: {}, b: {})", a, b);
            throw new ArithmeticException("Divisione per zero non consentita.");
        }
        double risultato = a / b;
        logger.info("Eseguita divisione: {} / {} = {}", a, b, risultato);
        return risultato;
    }

    public static void main(String[] args) {
        Calcolatrice calcolatrice = new Calcolatrice();

        // Esempio di utilizzo
        try {
            calcolatrice.somma(5, 3);
            calcolatrice.sottrazione(10, 4);
            calcolatrice.moltiplicazione(2, 6);
            calcolatrice.divisione(8, 2);
            calcolatrice.divisione(5, 0); // Questo genererà un errore
        } catch (ArithmeticException e) {
            logger.warn("Eccezione catturata: {}", e.getMessage());
        }
    }
}