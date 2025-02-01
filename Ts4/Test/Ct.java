import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcolatriceTest {

	@Test
	void testSomma() {
		Calcolatrice c=new Calcolatrice(); //Il test testSomma utilizza il metodo statico assertEquals
		assertEquals(2, c.somma(2, 0) ); 
	}

}
