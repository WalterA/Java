// Importazione delle classi necessarie per le Stream API e le collezioni
import java.util.Arrays;                         // Importa la classe Arrays per operazioni sugli array
import java.util.Comparator;                      // Importa la classe Comparator per ordinamenti personalizzati
import java.util.List;                            // Importa la classe List per le collezioni
import java.util.Map;                             // Importa la classe Map per le mappature
import java.util.Optional;                        // Importa la classe Optional per valori opzionali
import java.util.stream.Collectors;               // Importa Collectors per operazioni di raccolta
import java.util.stream.Stream;                   // Importa la classe Stream per creare e manipolare flussi

// Definizione della classe principale che contiene tutti gli esempi
public class StreamExamples {

    // Metodo principale: punto d'ingresso del programma
    public static void main(String[] args) {
        // Richiama ciascun esempio per dimostrare le funzionalità delle Stream API

        System.out.println("=== Esempio: Creazione di Stream da una Collezione ===");
        exampleFromCollection();  // Esegue la creazione di uno stream da una collezione

        System.out.println("\n=== Esempio: Creazione di Stream da un Array ===");
        exampleFromArray();       // Esegue la creazione di uno stream da un array

        System.out.println("\n=== Esempio: Creazione di uno Stream Statico ===");
        exampleStaticStream();    // Esegue la creazione di uno stream statico con Stream.of

        System.out.println("\n=== Esempio: Creazione di uno Stream Infinito (limitato) ===");
        exampleInfiniteStream();  // Esegue la creazione di uno stream infinito limitato

        System.out.println("\n=== Esempio: Operazione Filter ===");
        exampleFilter();          // Esegue il filtraggio degli elementi di uno stream

        System.out.println("\n=== Esempio: Operazione Map ===");
        exampleMap();             // Esegue la trasformazione degli elementi in maiuscolo

        System.out.println("\n=== Esempio: Operazione FlatMap ===");
        exampleFlatMap();         // Esegue la "appiattitura" di uno stream di collezioni

        System.out.println("\n=== Esempio: Operazione Sorted ===");
        exampleSorted();          // Esegue l'ordinamento naturale e decrescente di uno stream

        System.out.println("\n=== Esempio: Operazione Peek ===");
        examplePeek();            // Esegue l'operazione di peek per il debug dello stream

        System.out.println("\n=== Esempio: Operazione ForEach ===");
        exampleForEach();         // Esegue una stampa di ogni elemento tramite forEach

        System.out.println("\n=== Esempio: Operazione Collect ===");
        exampleCollect();         // Esegue la raccolta degli elementi in una lista

        System.out.println("\n=== Esempio: Operazione Reduce ===");
        exampleReduce();          // Esegue una riduzione cumulativa degli elementi (somma e prodotto)

        System.out.println("\n=== Esempio: Operazioni di Matching (anyMatch, allMatch, noneMatch) ===");
        exampleMatch();           // Verifica condizioni su tutti gli elementi dello stream

        System.out.println("\n=== Esempio: Operazione GroupingBy ===");
        exampleGroupingBy();      // Raggruppa gli elementi in base al primo carattere

        System.out.println("\n=== Esempio: Operazione PartitioningBy ===");
        examplePartitioningBy();  // Partiziona gli elementi in base ad un predicato (pari/dispari)

        System.out.println("\n=== Esempio: Utilizzo di ParallelStream ===");
        exampleParallelStream();  // Mostra l'esecuzione parallela dello stream

        System.out.println("\n=== Esempio: Operazioni Limit e Skip ===");
        exampleLimitSkip();       // Mostra l'utilizzo di skip e limit in uno stream infinito

        System.out.println("\n=== Esempio: Operazione Distinct ===");
        exampleDistinct();        // Rimuove gli elementi duplicati dallo stream

        System.out.println("\n=== Esempio: Operazioni Min e Max ===");
        exampleMinMax();          // Trova il valore minimo e massimo in uno stream
    }

    // Metodo che mostra come creare uno stream da una collezione
    public static void exampleFromCollection() {
        // Crea una lista di stringhe
        List<String> nomi = Arrays.asList("Alice", "Bob", "Charlie", "David"); // Lista di nomi
        // Crea uno stream dalla lista e per ogni elemento stampa il valore
        nomi.stream()                           // Converte la lista in uno stream
            .forEach(System.out::println);      // Stampa ogni elemento della stream
    }

    // Metodo che mostra come creare uno stream da un array
    public static void exampleFromArray() {
        // Definisce un array di stringhe
        String[] parole = {"Java", "Stream", "API", "Example"}; // Array di parole
        // Converte l'array in uno stream e stampa ogni elemento
        Arrays.stream(parole)                   // Converte l'array in uno stream
              .forEach(System.out::println);     // Stampa ogni elemento dello stream
    }

    // Metodo che mostra come creare uno stream statico
    public static void exampleStaticStream() {
        // Crea uno stream statico utilizzando Stream.of e stampa ogni elemento
        Stream.of("Uno", "Due", "Tre")           // Crea uno stream statico con tre elementi
              .forEach(System.out::println);     // Stampa ogni elemento della stream
    }

    // Metodo che mostra come creare uno stream infinito e limitarlo
    public static void exampleInfiniteStream() {
        // Genera uno stream infinito di numeri interi a partire da 0 e incrementando di 1
        Stream.iterate(0, n -> n + 1)            // Crea uno stream infinito che parte da 0 e incrementa di 1
              .limit(10)                         // Limita lo stream ai primi 10 elementi
              .forEach(System.out::println);     // Stampa ogni elemento della stream
    }

    // Metodo che mostra l'uso dell'operazione filter
    public static void exampleFilter() {
        // Crea una lista di numeri interi
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6); // Lista di numeri da 1 a 6
        // Filtra i numeri pari e li stampa
        numeri.stream()                         // Converte la lista in uno stream
              .filter(n -> n % 2 == 0)           // Filtra solo i numeri pari
              .forEach(System.out::println);     // Stampa i numeri filtrati
    }

    // Metodo che mostra l'uso dell'operazione map per trasformare gli elementi
    public static void exampleMap() {
        // Crea una lista di stringhe in minuscolo
        List<String> parole = Arrays.asList("java", "stream", "api"); // Lista di parole in minuscolo
        // Trasforma ogni parola in maiuscolo e la stampa
        parole.stream()                         // Converte la lista in uno stream
              .map(String::toUpperCase)          // Trasforma ogni stringa in maiuscolo
              .forEach(System.out::println);     // Stampa le stringhe trasformate
    }

    // Metodo che mostra l'uso dell'operazione flatMap per appiattire una struttura a liste multiple
    public static void exampleFlatMap() {
        // Crea una lista di liste di stringhe
        List<List<String>> listaDiListe = Arrays.asList(
            Arrays.asList("A", "B"),              // Prima lista con "A" e "B"
            Arrays.asList("C", "D"),              // Seconda lista con "C" e "D"
            Arrays.asList("E", "F")               // Terza lista con "E" e "F"
        );
        // Appiattisce la struttura e stampa ogni elemento
        listaDiListe.stream()                    // Converte la lista di liste in uno stream
                    .flatMap(List::stream)        // Appiattisce ogni lista in un singolo stream
                    .forEach(System.out::println); // Stampa ogni elemento appiattito
    }

    // Metodo che mostra l'uso dell'operazione sorted per ordinare gli elementi
    public static void exampleSorted() {
        // Crea una lista di numeri non ordinati
        List<Integer> numeri = Arrays.asList(5, 3, 8, 1, 2); // Lista di numeri
        // Ordina in maniera naturale e stampa
        numeri.stream()                         // Converte la lista in uno stream
              .sorted()                        // Ordina in ordine naturale (crescente)
              .forEach(System.out::println);     // Stampa i numeri ordinati

        // Stampa un separatore per indicare l'ordinamento decrescente
        System.out.println("Ordinamento decrescente:");
        // Ordina in maniera decrescente utilizzando un comparatore personalizzato e stampa
        numeri.stream()                         // Converte la lista in uno stream
              .sorted((a, b) -> b - a)           // Ordina in ordine decrescente
              .forEach(System.out::println);     // Stampa i numeri ordinati in ordine decrescente
    }

    // Metodo che mostra l'uso dell'operazione peek per eseguire azioni intermedie (es. debug)
    public static void examplePeek() {
        // Crea una lista di stringhe
        List<String> parole = Arrays.asList("uno", "due", "tre"); // Lista di parole
        // Utilizza peek per stampare ogni elemento prima della trasformazione in maiuscolo
        parole.stream()                         // Converte la lista in uno stream
              .peek(System.out::println)         // Esegue il debug stampando l'elemento corrente
              .map(String::toUpperCase)          // Trasforma ogni stringa in maiuscolo
              .forEach(System.out::println);     // Stampa l'elemento trasformato
    }

    // Metodo che mostra l'uso dell'operazione forEach per iterare e stampare gli elementi
    public static void exampleForEach() {
        // Crea una lista di lettere
        List<String> lettere = Arrays.asList("A", "B", "C", "D"); // Lista di lettere
        // Itera su ogni elemento e lo stampa con uno spazio
        lettere.stream()                        // Converte la lista in uno stream
               .forEach(lettera -> System.out.print(lettera + " ")); // Stampa ogni lettera seguita da uno spazio
        System.out.println();                    // Aggiunge una nuova riga dopo la stampa
    }

    // Metodo che mostra l'uso dell'operazione collect per raccogliere i risultati in una lista
    public static void exampleCollect() {
        // Crea una lista di nomi
        List<String> nomi = Arrays.asList("Anna", "Marco", "Luca", "Giulia"); // Lista di nomi
        // Trasforma ogni nome in maiuscolo e raccoglie i risultati in una nuova lista
        List<String> nomiMaiuscoli = nomi.stream() // Converte la lista in uno stream
                                        .map(String::toUpperCase) // Trasforma ogni nome in maiuscolo
                                        .collect(Collectors.toList()); // Raccoglie il risultato in una lista
        System.out.println(nomiMaiuscoli);      // Stampa la lista dei nomi trasformati
    }

    // Metodo che mostra l'uso dell'operazione reduce per eseguire una riduzione cumulativa degli elementi
    public static void exampleReduce() {
        // Crea una lista di numeri
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5); // Lista di numeri da 1 a 5
        // Utilizza reduce per sommare gli elementi
        Optional<Integer> somma = numeri.stream()  // Converte la lista in uno stream
                                        .reduce((a, b) -> a + b); // Riduce gli elementi sommandoli
        // Se la somma è presente, la stampa
        somma.ifPresent(System.out::println);     // Stampa il risultato della somma

        // Utilizza reduce con un valore iniziale per calcolare il prodotto degli elementi
        Integer prodotto = numeri.stream()        // Converte la lista in uno stream
                                 .reduce(1, (a, b) -> a * b); // Riduce gli elementi moltiplicandoli, partendo da 1
        System.out.println("Prodotto: " + prodotto); // Stampa il risultato del prodotto
    }

    // Metodo che mostra l'uso delle operazioni di matching: anyMatch, allMatch e noneMatch
    public static void exampleMatch() {
        // Crea una lista di numeri pari
        List<Integer> numeri = Arrays.asList(2, 4, 6, 8); // Lista di numeri pari
        // Verifica se tutti i numeri sono pari
        boolean tuttiPari = numeri.stream()       // Converte la lista in uno stream
                                  .allMatch(n -> n % 2 == 0); // Verifica che ogni numero sia pari
        // Verifica se almeno uno dei numeri è pari
        boolean almenoUnoPari = numeri.stream()   // Converte la lista in uno stream
                                      .anyMatch(n -> n % 2 == 0); // Verifica se almeno un numero è pari
        // Verifica se nessun numero è dispari
        boolean nessunoDispari = numeri.stream()  // Converte la lista in uno stream
                                       .noneMatch(n -> n % 2 != 0); // Verifica che nessun numero sia dispari
        // Stampa i risultati delle verifiche
        System.out.println("Tutti pari? " + tuttiPari);
        System.out.println("Almeno uno pari? " + almenoUnoPari);
        System.out.println("Nessuno dispari? " + nessunoDispari);
    }

    // Metodo che mostra l'uso dell'operazione groupingBy per raggruppare gli elementi
    public static void exampleGroupingBy() {
        // Crea una lista di parole
        List<String> parole = Arrays.asList("apple", "ant", "banana", "ball", "cat", "car"); // Lista di parole
        // Raggruppa le parole in base al loro primo carattere
        Map<Character, List<String>> paroleRaggruppate = parole.stream() // Converte la lista in uno stream
                                                               .collect(Collectors.groupingBy(s -> s.charAt(0))); // Raggruppa in base al primo carattere
        // Stampa la mappa risultante
        System.out.println(paroleRaggruppate);
    }

    // Metodo che mostra l'uso dell'operazione partitioningBy per partizionare gli elementi
    public static void examplePartitioningBy() {
        // Crea una lista di numeri
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6); // Lista di numeri da 1 a 6
        // Partiziona i numeri in base al predicato che verifica se sono pari
        Map<Boolean, List<Integer>> partizionati = numeri.stream() // Converte la lista in uno stream
                                                         .collect(Collectors.partitioningBy(n -> n % 2 == 0)); // Partiziona in base alla parità
        // Stampa la lista dei numeri pari
        System.out.println("Pari: " + partizionati.get(true));
        // Stampa la lista dei numeri dispari
        System.out.println("Dispari: " + partizionati.get(false));
    }

    // Metodo che mostra l'utilizzo di uno stream parallelo
    public static void exampleParallelStream() {
        // Crea una lista di numeri
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // Lista di numeri da 1 a 10
        // Utilizza parallelStream per elaborare gli elementi in parallelo
        numeri.parallelStream()                  // Converte la lista in uno stream parallelo
              .forEach(n ->                    // Per ogni numero, esegue una lambda
                  System.out.println("Thread: " + Thread.currentThread().getName() + " - " + n)
              );                                // Stampa il thread e il numero corrente
    }

    // Metodo che mostra l'utilizzo delle operazioni limit e skip in uno stream
    public static void exampleLimitSkip() {
        // Crea uno stream infinito di numeri
        Stream.iterate(0, n -> n + 1)            // Crea uno stream infinito che parte da 0 e incrementa di 1
              .skip(5)                          // Salta i primi 5 elementi
              .limit(10)                        // Limita lo stream ai successivi 10 elementi
              .forEach(System.out::println);    // Stampa ogni elemento dello stream risultante
    }

    // Metodo che mostra l'utilizzo dell'operazione distinct per rimuovere duplicati
    public static void exampleDistinct() {
        // Crea una lista di numeri con duplicati
        List<Integer> numeriConDuplicati = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5); // Lista con numeri duplicati
        // Rimuove i duplicati e stampa ogni numero
        numeriConDuplicati.stream()             // Converte la lista in uno stream
                          .distinct()           // Rimuove gli elementi duplicati
                          .forEach(System.out::println); // Stampa ogni elemento unico
    }

    // Metodo che mostra l'utilizzo delle operazioni min e max per trovare il valore minimo e massimo
    public static void exampleMinMax() {
        // Crea una lista di numeri
        List<Integer> numeri = Arrays.asList(10, 20, 5, 30, 15); // Lista di numeri
        // Trova il valore minimo utilizzando l'ordinamento naturale
        Optional<Integer> minimo = numeri.stream()  // Converte la lista in uno stream
                                          .min(Integer::compareTo); // Trova il minimo elemento
        // Trova il valore massimo utilizzando l'ordinamento naturale
        Optional<Integer> massimo = numeri.stream() // Converte la lista in uno stream
                                           .max(Integer::compareTo); // Trova il massimo elemento
        // Se il minimo è presente, lo stampa
        minimo.ifPresent(min -> System.out.println("Minimo: " + min));
        // Se il massimo è presente, lo stampa
        massimo.ifPresent(max -> System.out.println("Massimo: " + max));
    }
}

