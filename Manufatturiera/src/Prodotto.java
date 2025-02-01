import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Prodotto {
	private String tessuto;
	private Integer metri;
	private String id_tessitrice;
	
	public Prodotto(String tessuto, int metri, String id_tessitrice) {
		super();
		this.tessuto = tessuto;
		this.metri = metri;
		this.id_tessitrice = id_tessitrice;
	}
	
	public String getTessuto() {
		return tessuto;
	}

	public void setTessuto(String tessuto) {
		this.tessuto = tessuto;
	}

	public Integer getMetri() {
		return metri;
	}

	public void setMetri(Integer metri) {
		this.metri = metri;
	}

	public String getId_tessitrice() {
		return id_tessitrice;
	}

	public void setId_tessitrice(String id_tessitrice) {
		this.id_tessitrice = id_tessitrice;
	}

	public Prodotto() {
		super();
	}
}
