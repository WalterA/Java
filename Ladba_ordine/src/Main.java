import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Lista di colori
        List<String> colors = Arrays.asList("red", "green", "blue", "black", "pink");

        // Ordinamento della lista in ordine crescente
        Collections.sort(colors, (color1, color2) -> color1.compareTo(color2));

        // Stampa della lista ordinata
        System.out.println("Lista ordinata: " + colors);
    }
}
