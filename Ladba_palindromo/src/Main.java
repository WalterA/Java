public class Main {
    public static void main(String[] args) {
        // Implementazione dell'interfaccia tramite una lambda expression
        VerificatoreParola verificatore = parola -> {
            String invertita = new StringBuilder(parola).reverse().toString();
            return parola.equalsIgnoreCase(invertita);
        };

        // Test dell'espressione lambda
        String parola1 = "anna";
        String parola2 = "casa";

        System.out.println("La parola \"" + parola1 + "\" è palindroma? " + verificatore.verifica(parola1));
        System.out.println("La parola \"" + parola2 + "\" è palindroma? " + verificatore.verifica(parola2));
    }
}

