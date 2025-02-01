import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Utente {
    private String nome;
    private String cognome;
    private int eta;
    private String citta;
    private String altro;

    public Utente(String nome, String cognome, int eta, String citta, String altro) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.citta = citta;
        this.altro = altro;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + ", " + eta + " anni, " + citta;
    }
}
