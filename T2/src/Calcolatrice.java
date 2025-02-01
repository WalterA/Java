public class Calcolatrice {

    // Metodo per l'addizione
    public int somma(int a, int b) {
        return a + b;
    }

    // Metodo per la sottrazione
    public int sottrai(int a, int b) {
        return a - b;
    }

    // Metodo per la moltiplicazione
    public int moltiplica(int a, int b) {
        return a * b;
    }

    // Metodo per la divisione
    public int dividi(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisione per zero non consentita");
        }
        return a / b;
    }

    // Metodo statico per calcolare un'operazione da una stringa
    public static int calcola(String input) {
        input = input.replaceAll(" ", ""); // Rimuove gli spazi bianchi
        String[] operatori = input.split("[0-9]+");
        String[] operandi = input.split("[\\+\\-\\*\\/]");
        
        if (operandi.length == 1) {
            return Integer.parseInt(operandi[0]); // Ritorna il singolo operando
        }

        if (operandi.length != 2 || operatori.length < 2) {
            throw new IllegalArgumentException("Input non valido");
        }

        int op1 = Integer.parseInt(operandi[0]);
        int op2 = Integer.parseInt(operandi[1]);
        String operatore = operatori[1];

        switch (operatore) {
        case "+":
            return op1 + op2;
        case "-":
            return op1 - op2;
        case "*":
            return op1 * op2;
        case "/":
            if (op2 == 0) {
                throw new ArithmeticException("Divisione per zero non consentita");
            }
            return op1 / op2;
        default:
            throw new IllegalArgumentException("Operatore non valido");
    }

    }
}
