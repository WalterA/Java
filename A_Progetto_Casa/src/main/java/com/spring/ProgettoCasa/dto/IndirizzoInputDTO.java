package com.spring.ProgettoCasa.dto;
import jakarta.validation.constraints.*;

public class IndirizzoInputDTO {
    
    @NotBlank(message = "La via non può essere vuota")
    @Size(max = 200, message = "La via non può superare 200 caratteri")
    private String via;

    @NotBlank(message = "Il CAP non può essere vuoto")
    @Pattern(regexp = "^\\d{5}$", message = "Il CAP deve essere di 5 cifre")
    private String cap;

    @NotBlank(message = "La città non può essere vuota")
    @Size(max = 100, message = "La città non può superare 100 caratteri")
    private String citta;

    @NotBlank(message = "Il paese non può essere vuoto")
    @Size(max = 100, message = "Il paese non può superare 100 caratteri")
    private String paese;

    public IndirizzoInputDTO() {}

    public IndirizzoInputDTO(String via, String cap, String citta, String paese) {
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.paese = paese;
    }

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