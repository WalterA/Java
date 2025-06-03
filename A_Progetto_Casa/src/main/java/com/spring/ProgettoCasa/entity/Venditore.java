package com.spring.ProgettoCasa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "venditore")
public class Venditore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(max = 100, message = "Il nome non può superare 100 caratteri")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(max = 100, message = "Il cognome non può superare 100 caratteri")
    @Column(name = "cognome", nullable = false)
    private String cognome;

    @NotBlank(message = "L'username non può essere vuoto")
    @Size(min = 3, max = 50, message = "L'username deve essere tra 3 e 50 caratteri")
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 6, message = "La password deve essere almeno 6 caratteri")
    @Column(name = "password", nullable = false)
    private String password;

    // Relazione OneToOne con Indirizzo (opzionale)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "residenza_id", nullable = true)
    @JsonManagedReference
    private Indirizzo residenza;

    // Relazione OneToMany con Prodotto
    @OneToMany(mappedBy = "venditore", 
               cascade = CascadeType.ALL, 
               fetch = FetchType.LAZY, 
               orphanRemoval = true)
    @JsonManagedReference
    private List<Prodotto> prodottiInVendita = new ArrayList<>();

    // Costruttori
    public Venditore() {
        super();
    }

    public Venditore(String nome, String cognome, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.prodottiInVendita = new ArrayList<>();
    }

    // Getter e Setter
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Indirizzo getResidenza() {
        return residenza;
    }

    public void setResidenza(Indirizzo residenza) {
        this.residenza = residenza;
        if (residenza != null) {
            residenza.setVenditore(this);
        }
    }

    public List<Prodotto> getProdottiInVendita() {
        return prodottiInVendita;
    }

    public void setProdottiInVendita(List<Prodotto> prodottiInVendita) {
        this.prodottiInVendita = prodottiInVendita;
    }

    // Metodi di utilità per gestire la relazione con Prodotto
    public void aggiungiProdotto(Prodotto prodotto) {
        if (prodottiInVendita == null) {
            prodottiInVendita = new ArrayList<>();
        }
        prodottiInVendita.add(prodotto);
        prodotto.setVenditore(this);
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        if (prodottiInVendita != null) {
            prodottiInVendita.remove(prodotto);
            prodotto.setVenditore(null);
        }
    }

    // Metodi di utilità
    public boolean hasResidenza() {
        return this.residenza != null;
    }

    public boolean hasProdottiInVendita() {
        return this.prodottiInVendita != null && !this.prodottiInVendita.isEmpty();
    }

    public int getNumeroProdottiInVendita() {
        return this.prodottiInVendita != null ? this.prodottiInVendita.size() : 0;
    }

    // Calcola la quantità totale di prodotti disponibili di questo venditore
    public int getQuantitaTotaleProdotti() {
        if (prodottiInVendita == null) {
            return 0;
        }
        return prodottiInVendita.stream()
                .mapToInt(prodotto -> prodotto.getQuantita() != null ? prodotto.getQuantita() : 0)
                .sum();
    }

    @Override
    public String toString() {
        return "Venditore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", hasResidenza=" + hasResidenza() +
                ", numeroProdotti=" + getNumeroProdottiInVendita() +
                '}';
    }
}