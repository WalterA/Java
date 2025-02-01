import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<Utente> elencoUtenti() {
        List<Utente> utenti = new ArrayList<>();
        utenti.add(new Utente("Paolo", "Rossi", 39, "Roma", "test"));
        utenti.add(new Utente("Mario", "Rossi", 40, "Roma", "test"));
        utenti.add(new Utente("Antonio", "Di Girolamo", 23, "Roma", "test"));
        utenti.add(new Utente("Caterina", "Montefalco", 55, "Roma", "test"));
        utenti.add(new Utente("Valeria", "Natelli", 45, "Roma", "test"));
        utenti.add(new Utente("Giovanna", "D'Antonelli", 50, "Roma", "test"));
        utenti.add(new Utente("Paolo", "Pisani", 21, "Catanzaro", "test"));
        utenti.add(new Utente("Laura", "Gambaro", 19, "Roma", "test"));
        utenti.add(new Utente("Benedetto", "Satini", 38, "Roma", "test"));
        return utenti;
    }

    public static void main(String[] args) {
        List<Utente> utenti = elencoUtenti();

        // Ricerca per nome
        String nomeRicerca = "Paolo";
        List<Utente> utentiConNome = utenti.stream()
            .filter(utente -> utente.getNome().equalsIgnoreCase(nomeRicerca))
            .collect(Collectors.toList());
        System.out.println("Utenti con nome \"" + nomeRicerca + "\":");
        utentiConNome.forEach(System.out::println);

        // Utenti con età maggiore di 40 anni
        int etaMinima = 40;
        List<Utente> utentiEtaMaggioreDi = utenti.stream()
            .filter(utente -> utente.getEta() > etaMinima)
            .collect(Collectors.toList());
        System.out.println("\nUtenti con età maggiore di " + etaMinima + ":");
        utentiEtaMaggioreDi.forEach(System.out::println);

        // Utenti che abitano in una città specifica
        String cittaRicerca = "Roma";
        List<Utente> utentiDiCitta = utenti.stream()
            .filter(utente -> utente.getCitta().equalsIgnoreCase(cittaRicerca))
            .collect(Collectors.toList());
        System.out.println("\nUtenti che abitano a " + cittaRicerca + ":");
        utentiDiCitta.forEach(System.out::println);
    }
}