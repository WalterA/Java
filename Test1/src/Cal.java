import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Cal {

	@Test
	void testSomma() {
			Calcolatrice c=new Calcolatrice(); //Il test testSomma utilizza il metodo statico assertEquals
			assertEquals(2, c.somma(2, 2) ); // per verificare che il metodo somma restituisca la somma
			}
			}


