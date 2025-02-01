import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Creazione dell'ArrayList con i numeri
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);

        // Implementazione di Consumer per stampare i numeri
        Consumer<Integer> stampaNumero = numero -> System.out.println("Numero: " + numero);

        // Applicazione del Consumer su ogni elemento della lista
        numbers.forEach(stampaNumero);
        
    }
}
