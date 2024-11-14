public class Romanzo extends Libro {
    private String genere;

    public Romanzo(String titolo, String autore, String genere) {
        super(titolo, autore);
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    // Sovrascrittura del metodo descrivi() per includere il genere
    @Override
    public String descrivi() {
        return super.descrivi() + ", Genere: " + genere;
    }
}
