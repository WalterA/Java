package com.spring.ProgettoCasa.dto;
public class IndirizzoOutputDTO {
    
    private Integer id;
    private String via;
    private String cap;
    private String citta;
    private String paese;

    public IndirizzoOutputDTO() {}

    public IndirizzoOutputDTO(Integer id, String via, String cap, String citta, String paese) {
        this.id = id;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.paese = paese;
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