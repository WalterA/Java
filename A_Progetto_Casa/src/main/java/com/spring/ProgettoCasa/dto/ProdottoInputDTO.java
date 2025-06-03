package com.spring.ProgettoCasa.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
//ProdottoInputDTO - per creazione (include venditoreId obbligatorio)
public class ProdottoInputDTO {
    
    @NotBlank(message = "La descrizione non può essere vuota")
    @Size(max = 500, message = "La descrizione non può superare 500 caratteri")
    private String descrizione;

    @NotNull(message = "La quantità non può essere nulla")
    @Min(value = 0, message = "La quantità non può essere negativa")
    private Integer quantita;

    @NotNull(message = "Il prezzo non può essere nullo")
    @DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di 0")
    @Digits(integer = 10, fraction = 2, message = "Il prezzo non può avere più di 2 cifre decimali")
    private BigDecimal prezzo;

    @NotNull(message = "Lo sconto non può essere nullo")
    @Min(value = 0, message = "Lo sconto non può essere negativo")
    @Max(value = 100, message = "Lo sconto non può essere superiore al 100%")
    private Integer sconto;

    // ID del venditore (obbligatorio)
    @NotNull(message = "L'ID del venditore è obbligatorio")
    private Integer venditoreId;

    // ID della categoria (opzionale come specificato nei requisiti)
    private Integer categoriaId;

    public ProdottoInputDTO() {}

    public ProdottoInputDTO(String descrizione, Integer quantita, BigDecimal prezzo, 
                           Integer sconto, Integer venditoreId) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.venditoreId = venditoreId;
    }

    // Getter e Setter
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

    public Integer getVenditoreId() {
        return venditoreId;
    }

    public void setVenditoreId(Integer venditoreId) {
        this.venditoreId = venditoreId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}