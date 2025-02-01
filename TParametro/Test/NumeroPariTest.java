import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumeroPariTest {

    private final NumeroPari numeroPari = new NumeroPari();

    @ParameterizedTest
    @CsvSource({
        "2, false",
        "2, true",
        "3, false",
        "4, true",
        "5, false"
    })
    void testNumeroPari(int input, boolean expected) {
        // Esegue il test
        boolean result = numeroPari.numeroPari(input);

        // Verifica il risultato
        assertEquals(expected, result);
    }
}
