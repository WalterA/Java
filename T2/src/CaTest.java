import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaTest {

    // Crea un'istanza della classe Calcolatrice
    Calcolatrice calcolatrice = new Calcolatrice();

    @Test
    void testSomma() {
        assertEquals(30, calcolatrice.somma(10, 20), "La somma non restituisce il valore corretto.");
        assertEquals(0, calcolatrice.somma(-10, 10), "La somma non restituisce il valore corretto per numeri negativi.");
    }

    @Test
    void testSottrai() {
        assertEquals(10, calcolatrice.sottrai(30, 20), "La sottrazione non restituisce il valore corretto.");
        assertEquals(-20, calcolatrice.sottrai(-10, 10), "La sottrazione non restituisce il valore corretto per numeri negativi.");
    }

    @Test
    void testMoltiplica() {
        assertEquals(50, calcolatrice.moltiplica(5, 10), "La moltiplicazione non restituisce il valore corretto.");
        assertEquals(0, calcolatrice.moltiplica(0, 10), "La moltiplicazione con zero non restituisce il valore corretto.");
    }

    @Test
    void testDividi() {
        assertEquals(5, calcolatrice.dividi(10, 2), "La divisione non restituisce il valore corretto.");
        assertThrows(ArithmeticException.class, () -> calcolatrice.dividi(10, 0), 
            "La divisione per zero non solleva un'eccezione.");
    }

    @Test
    void testCalcola() {
        assertEquals(30, Calcolatrice.calcola("10 + 20"), "Calcolo non corretto per somma.");
        assertEquals(10, Calcolatrice.calcola("30 - 20"), "Calcolo non corretto per sottrazione.");
        assertEquals(50, Calcolatrice.calcola("5 * 10"), "Calcolo non corretto per moltiplicazione.");
        assertEquals(5, Calcolatrice.calcola("10 / 2"), "Calcolo non corretto per divisione.");
        assertEquals(42, Calcolatrice.calcola("42"), "Calcolo non corretto per singolo operando.");
    }

    @Test
    void testCalcolaInputNonValido() {
        assertThrows(IllegalArgumentException.class, () -> Calcolatrice.calcola("10 +"), 
            "Input non valido non solleva eccezione.");
        assertThrows(IllegalArgumentException.class, () -> Calcolatrice.calcola("abc"), 
            "Input non valido non solleva eccezione.");
    }
}
