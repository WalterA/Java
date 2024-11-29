import java.lang.runtime.ObjectMethods;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Persona {
	private Long id;
	private Boolean femmina;
	private Double stipendio;
	public Set<Integer> numeri;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getFemmina() {
		return femmina;
	}

	public void setFemmina(Boolean femmina) {
		this.femmina = femmina;
	}

	public Double getStipendio() {
		return stipendio;
	}

	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}

	public Persona(Long id, Boolean femmina, Double stipendio) {
		super();
		this.id = id;
		this.femmina = femmina;
		this.stipendio = stipendio;
		numeri = new HashSet<Integer>();
		Random rng = new Random();
		numeri.add(rng.nextInt());
		numeri.add(rng.nextInt());
		numeri.add(rng.nextInt());
	}

	public Persona() {
		super();
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", femmina=" + femmina + ", stipendio=" + stipendio + ", numeri=" + numeri + "]";
	}

	public String SerializeJson() {
		// return String.format("{\"id\":%d,\"femmina\":%b,\"stipendio\":%.2f}",
		// getId(), getFemmina(), getStipendio());
		ObjectMapper objectMapper = new ObjectMapper();
		String ret = "";
		try {
			ret = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public Persona DeserializeJson(String s) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Persona p = objectMapper.readValue(s, Persona.class);
			return p;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;

	}
	
}
