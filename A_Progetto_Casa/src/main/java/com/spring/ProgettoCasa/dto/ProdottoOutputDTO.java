package com.spring.ProgettoCasa.dto;

import java.math.BigDecimal;
//ProdottoOutputDTO - per visualizzazione completa
public class ProdottoOutputDTO {
    
    private Integer id;
    private String descrizione;
    private Integer quantita;
    private BigDecimal prezzo;
    private Integer sconto;
    private CategoriaOutputDTO categoria;
    private VenditoreBasicDTO venditore;

    public ProdottoOutputDTO() {}

    public ProdottoOutputDTO(Integer id, String descrizione, Integer quantita, 
                            BigDecimal prezzo, Integer sconto) {
        this.id = id;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.sconto = sconto;
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

    public CategoriaOutputDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaOutputDTO categoria) {
        this.categoria = categoria;
    }

    public VenditoreBasicDTO getVenditore() {
        return venditore;
    }

    public void setVenditore(VenditoreBasicDTO venditore) {
        this.venditore = venditore;
    }
}