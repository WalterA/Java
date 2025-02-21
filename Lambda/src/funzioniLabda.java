import java.util.function.BiFunction;


public class funzioniLabda {

	public static void main(String[] args) {
		 BiFunction<Integer, Integer, Integer> somma = (a, b) -> a + b;

	        // Utilizziamo il BiFunction per sommare 4 e 5
	        Integer risultato = somma.apply(4, 5);

	        // Stampa il risultato
	        System.out.println("La somma è: " + risultato);
	        BiFunction<Float, Integer, Float> divisione = (a,b) -> a/b;
	        Float risulatato =divisione.apply(3.5f, 5);
	        System.out.println(risultato);
	}

}
