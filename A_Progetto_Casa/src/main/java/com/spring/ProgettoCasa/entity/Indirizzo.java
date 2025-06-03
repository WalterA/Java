package com.spring.ProgettoCasa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "La via non può essere vuota")
    @Size(max = 255, message = "La via non può superare 255 caratteri")
    @Column(name = "via", nullable = false)
    private String via;

    @NotBlank(message = "La città non può essere vuota")
    @Size(max = 100, message = "La città non può superare 100 caratteri")
    @Column(name = "citta", nullable = false)
    private String citta;

    @NotBlank(message = "Il paese non può essere vuoto")
    @Size(max = 100, message = "Il paese non può superare 100 caratteri")
    @Column(name = "paese", nullable = false)
    private String paese;

    @NotNull(message = "Il CAP non può essere vuoto")
    @Min(value = 10000, message = "CAP deve essere di 5 cifre")
    @Max(value = 99999, message = "CAP deve essere di 5 cifre")
    @Column(name = "cap", nullable = false)
    private Integer cap;

    // Relazione OneToOne bidirezionale con Venditore
    @OneToOne(mappedBy = "residenza", fetch = FetchType.LAZY)
    @JsonBackReference
    private Venditore venditore;

    // Costruttori
    public Indirizzo() {
        super();
    }

    public Indirizzo(String via, String citta, String paese, Integer cap) {
        super();
        this.via = via;
        this.citta = citta;
        this.paese = paese;
        this.cap = cap;
    }

    // Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public Venditore getVenditore() {
        return venditore;
    }

    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }

    // Metodo di utilità
    public boolean hasVenditore() {
        return this.venditore != null;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "id=" + id +
                ", via='" + via + '\'' +
                ", citta='" + citta + '\'' +
                ", paese='" + paese + '\'' +
                ", cap=" + cap +
                ", venditoreDasIdAssociato=" + (venditore != null ? venditore.getId() : "null") +
                '}';
    }
}