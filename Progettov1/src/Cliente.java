//Una classe Cliente con ID del cliente, nome, cognome, e-mail, password etc.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private Integer id;
	private String nome, cognome, email, password;
	private List<Prodotto> carrello;

	public Cliente(Integer id, String nome, String cognome, String email, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.carrello = new ArrayList<Prodotto>();
	}

	public List<Prodotto> getCarrello() {
		return carrello;
	}

	public void setCarrello(List<Prodotto> carrello) {
		this.carrello = carrello;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void aggiungi(Prodotto p) {
		carrello.add(p);
	}

	public void mostraCarrello() {
		System.out.println("Prodotti acquistati da " + nome + " " + cognome + ":");
		for (Prodotto p : carrello) {
			System.out.println(p);
		}
	}
	public void salvaInFile() throws IOException {
	 String fileName = "cliente.txt";
     File file = new File(fileName);
     if (!file.exists()) {
         file.createNewFile();  // Crea il file se non esiste
     }

     try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
         writer.write("ID Cliente: " + id);
         writer.newLine();
         writer.write("Nome: " + nome);
         writer.newLine();
         writer.write("Cognome: " + cognome);
         writer.newLine();
         writer.write("Email: " + email);
         writer.newLine();
         writer.write("Password: " + password);
         writer.newLine();
         writer.write("Acquisti: ");
         writer.newLine();

         for (Prodotto prodotto : carrello) {
             writer.write("- " + prodotto.toString());
             writer.newLine();
         }

         writer.write("----------");
         writer.newLine();
         System.out.println("Cliente " + nome + " " + cognome + " salvato nel file " + fileName);
     }	
 }
}
