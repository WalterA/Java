public class Main {
    public static void main(String[] args) {
        // Creazione di oggetti per testare le classi
        Libro libroGenerico = new Libro("Il Grande Libro", "Autore Generico");
        Romanzo romanzo = new Romanzo("Il Signore degli Anelli", "J.R.R. Tolkien", "Fantasy");
        Enciclopedia enciclopedia = new Enciclopedia("Enciclopedia Universale", "Autore Enciclopedico", 10);

        // Chiamata al metodo descrivi per ogni oggetto
        System.out.println(libroGenerico.descrivi());
        System.out.println(romanzo.descrivi());
        System.out.println(enciclopedia.descrivi());
    }
}
