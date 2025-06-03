package com.spring.ProgettoCasa.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descrizione", nullable = false, length = 255)
    @NotBlank(message = "La descrizione è obbligatoria")
    private String descrizione;

    @Column(name = "quantita", nullable = false)
    @NotNull(message = "La quantità è obbligatoria")
    @Min(value = 0, message = "La quantità non può essere negativa")
    private Integer quantita;

    @NotNull(message = "Il prezzo è obbligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "Il prezzo deve essere maggiore di zero")
    @Column(name = "prezzo", nullable = false, precision = 10, scale = 2)
    private BigDecimal prezzo;

    @Column(name = "sconto", nullable = false)
    @NotNull(message = "Lo sconto è obbligatorio")
    @Min(value = 0, message = "Lo sconto non può essere negativo")
    @Max(value = 100, message = "Lo sconto non può essere superiore al 100%")
    private Integer sconto;

    // Relazione Many-to-One con Categoria (opzionale secondo la traccia)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = true)
    @JsonBackReference
    private Categoria categoria;

    // Relazione Many-to-One con Venditore (obbligatoria)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venditore_id", nullable = false)
    @NotNull(message = "Il venditore è obbligatorio")
    @JsonBackReference
    private Venditore venditore;

    // Costruttori
    public Prodotto() {
        super();
    }

    public Prodotto(String descrizione, Integer quantita, BigDecimal prezzo, Integer sconto) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.sconto = sconto;
    }

    public Prodotto(String descrizione, Integer quantita, BigDecimal prezzo, Integer sconto, 
                    Categoria categoria, Venditore venditore) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.categoria = categoria;
        this.venditore = venditore;
    }

    // Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getSconto() {
        return sconto;
    }

    public void setSconto(Integer sconto) {
        this.sconto = sconto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Venditore getVenditore() {
        return venditore;
    }

    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }

    // Metodi di utilità
    public BigDecimal getPrezzoScontato() {
        if (sconto == null || sconto == 0 || prezzo == null) {
            return prezzo;
        }
        BigDecimal scontoPercentuale = new BigDecimal(sconto).divide(new BigDecimal(100));
        BigDecimal importoSconto = prezzo.multiply(scontoPercentuale);
        return prezzo.subtract(importoSconto).setScale(2, RoundingMode.HALF_UP);
    }

    public boolean isDisponibile() {
        return quantita != null && quantita > 0;
    }

    public boolean isScontato() {
        return sconto != null && sconto > 0;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                ", sconto=" + sconto +
                ", categoria=" + (categoria != null ? categoria.getNome() : "null") +
                ", venditore=" + (venditore != null ? venditore.getUsername() : "null") +
                '}';
    }
}