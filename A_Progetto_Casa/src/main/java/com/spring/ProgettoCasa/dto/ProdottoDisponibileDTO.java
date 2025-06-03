package com.spring.ProgettoCasa.dto;

import java.math.BigDecimal;
//ProdottoDisponibileDTO - per prodotti disponibili
public class ProdottoDisponibileDTO {
    
    private String descrizione;
    private BigDecimal prezzo;

    public ProdottoDisponibileDTO() {}

    public ProdottoDisponibileDTO(String descrizione, BigDecimal prezzo) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    // Getter e Setter
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}