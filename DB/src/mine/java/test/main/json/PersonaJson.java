package mine.java.test.main.json;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class PersonaJson implements Serializable {
    @Serial
    private static final long serialVersionUID = 2846670478107600113L;

    protected int id;
    protected String nome;
    protected String cognome;
    protected BigDecimal stipendio;
    protected String posizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public BigDecimal getStipendio() {
        return stipendio;
    }

    public void setStipendio(BigDecimal stipendio) {
        this.stipendio = stipendio;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonaJson that = (PersonaJson) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(stipendio, that.stipendio) && Objects.equals(posizione, that.posizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, stipendio, posizione);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonaJson{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append(", stipendio=").append(stipendio);
        sb.append(", posizione='").append(posizione).append('\'');
        sb.append('}');
        return sb.toString();
    }
}