import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Implementazione dell'interfaccia tramite una lambda expression
        CalcolatoreMedia calcolatore = lista -> {
            if (lista.isEmpty()) {
                return 0.0; // Gestisce il caso di lista vuota
            }
            int somma = lista.stream().mapToInt(Integer::intValue).sum();
            return (double) somma / lista.size();
        };

        // Test dell'espressione lambda
        List<Integer> numeri = List.of(1, 2, 3, 4, 5);

        double media = calcolatore.calcola(numeri);
        System.out.println("La media della lista " + numeri + " è: " + media);
    }
}

