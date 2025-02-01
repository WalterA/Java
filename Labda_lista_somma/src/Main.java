import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Sommatore sommatore = lista -> {
		    int somma = 0;
		    for (int numero : lista) {
		        somma += numero;
		    }
		    return somma;
		};
	        
	        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5);

	        int risultato = sommatore.somma(numeri);
	        System.out.println("La somma della lista " + numeri + " è: " + risultato);

	}

}
