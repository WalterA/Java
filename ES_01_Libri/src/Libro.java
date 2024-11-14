public class Libro {
    private String titolo;
    private String autore;

    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    // Metodo descrivi() che fornisce una descrizione del libro
    public String descrivi() {
        return "Titolo: " + titolo + ", Autore: " + autore;
    }
}
