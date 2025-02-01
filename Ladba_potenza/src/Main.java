public class Main {
    public static void main(String[] args) {
        // Implementazione dell'interfaccia tramite una lambda expression
        CalcolatorePotenza calcolatore = (base, esponente) -> (int) Math.pow(base, esponente);

        // Test dell'espressione lambda
        int base = -2;
        int esponente = 5;

        int risultato = calcolatore.calcola(base, esponente);
        System.out.println(base + " elevato a " + esponente + " è: " + risultato);
    }
}
