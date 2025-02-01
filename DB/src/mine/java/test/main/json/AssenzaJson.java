package mine.java.test.main.json;

import org.bson.types.ObjectId;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class AssenzaJson implements Serializable {
    @Serial
    private static final long serialVersionUID = -5665582216659559843L;

    protected int id;
    protected String tipo;
    protected long giorno;
    protected ObjectId persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getGiorno() {
        return giorno;
    }

    public void setGiorno(long giorno) {
        this.giorno = giorno;
    }

    public ObjectId getPersona() {
        return persona;
    }

    public void setPersona(ObjectId persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AssenzaJson that = (AssenzaJson) o;
        return id == that.id && giorno == that.giorno && Objects.equals(tipo, that.tipo) && Objects.equals(persona, that.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, giorno, persona);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssenzaJson{");
        sb.append("id=").append(id);
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append(", giorno=").append(giorno);
        sb.append(", persona=").append(persona);
        sb.append('}');
        return sb.toString();
    }
}