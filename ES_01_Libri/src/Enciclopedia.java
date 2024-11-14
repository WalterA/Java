public class Enciclopedia extends Libro {
    private int numeroVolumi;

    public Enciclopedia(String titolo, String autore, int numeroVolumi) {
        super(titolo, autore);
        this.numeroVolumi = numeroVolumi;
    }

    public int getNumeroVolumi() {
        return numeroVolumi;
    }

    // Sovrascrittura del metodo descrivi() per includere il numero di volumi
    @Override
    public String descrivi() {
        return super.descrivi() + ", Numero Volumi: " + numeroVolumi;
    }
}
