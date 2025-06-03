package com.spring.ProgettoCasa.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria", 
               fetch = FetchType.LAZY, 
               cascade = CascadeType.ALL,
               orphanRemoval = false)
    @JsonManagedReference
    private List<Prodotto> prodotti = new ArrayList<>();

    // Costruttori
    public Categoria() {
        super();
    }

    public Categoria(@NotBlank(message = "Il nome non può essere vuoto") String nome) {
        super();
        this.nome = nome;
        this.prodotti = new ArrayList<>();
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

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    // Metodi di utilità per gestire la relazione bidirezionale
    public void addProdotto(Prodotto prodotto) {
        if (prodotto != null) {
            this.prodotti.add(prodotto);
            prodotto.setCategoria(this);
        }
    }

    public void removeProdotto(Prodotto prodotto) {
        if (prodotto != null) {
            this.prodotti.remove(prodotto);
            prodotto.setCategoria(null);
        }
    }

    public void clearProdotti() {
        for (Prodotto prodotto : this.prodotti) {
            prodotto.setCategoria(null);
        }
        this.prodotti.clear();
    }

    public int getNumeroProdotti() {
        return this.prodotti.size();
    }

    public boolean hasProdotti() {
        return !this.prodotti.isEmpty();
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroProdotti=" + (prodotti != null ? prodotti.size() : 0) +
                '}';
    }
}