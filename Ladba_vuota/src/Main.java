import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Lambda per verificare se una stringa è vuota
        Predicate<String> isEmpty = stringa -> stringa == null || stringa.isEmpty();

        // Test con alcune stringhe
        String stringa1 = "";
        String stringa2 = "Test";
        String stringa3 = null;

        System.out.println("La stringa1 è vuota? " + isEmpty.test(stringa1));
        System.out.println("La stringa2 è vuota? " + isEmpty.test(stringa2));
        System.out.println("La stringa3 è vuota? " + isEmpty.test(stringa3));
    }
}
