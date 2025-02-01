public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci l'operazione: ");
        String input = scanner.nextLine();
        try {
            int result = calculate(input);
            System.out.println("Risultato: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }

    public static int calculate(String input) {
        input = input.replaceAll(" ", "");
        String[] operators = input.split("[0-9]+");
        String[] operands = input.split("[\\+\\-\\*\\/]");
        
        if (operands.length == 1) {
            return Integer.parseInt(operands[0]); // Single operand
        }

        if (operands.length != 2 || operators.length < 2) {
            throw new IllegalArgumentException("Input non valido");
        }

        int op1 = Integer.parseInt(operands[0]);
        int op2 = Integer.parseInt(operands[1]);
        String operator = operators[1];

        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op2 != 0 ? op1 / op2 : throw new IllegalArgumentException("Divisione per zero non consentita");
            default -> throw new IllegalArgumentException("Operatore non valido");
        };
    }
}
