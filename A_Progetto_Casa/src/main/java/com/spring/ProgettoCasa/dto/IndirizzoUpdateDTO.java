package com.spring.ProgettoCasa.dto;

import jakarta.validation.constraints.*;

public class IndirizzoUpdateDTO {
    
    @Size(max = 200, message = "La via non può superare 200 caratteri")
    private String via;

    @Pattern(regexp = "^\\d{5}$|^$", message = "Il CAP deve essere di 5 cifre")
    private String cap;

    @Size(max = 100, message = "La città non può superare 100 caratteri")
    private String citta;

    @Size(max = 100, message = "Il paese non può superare 100 caratteri")
    private String paese;

    public IndirizzoUpdateDTO() {}

    // Getter e Setter
    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
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
}