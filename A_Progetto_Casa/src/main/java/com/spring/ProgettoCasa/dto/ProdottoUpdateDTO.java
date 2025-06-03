package com.spring.ProgettoCasa.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
//ProdottoUpdateDTO - per modifiche
public class ProdottoUpdateDTO {
    
    @Size(max = 500, message = "La descrizione non può superare 500 caratteri")
    private String descrizione;

    @Min(value = 0, message = "La quantità non può essere negativa")
    private Integer quantita;

    @DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di 0")
    @Digits(integer = 10, fraction = 2, message = "Il prezzo non può avere più di 2 cifre decimali")
    private BigDecimal prezzo;

    @Min(value = 0, message = "Lo sconto non può essere negativo")
    @Max(value = 100, message = "Lo sconto non può essere superiore al 100%")
    private Integer sconto;

    private Integer categoriaId;

    public ProdottoUpdateDTO() {}

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

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}