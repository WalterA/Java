package com.spring.ProgettoCasa.dto;

import java.util.List;
public class VenditoreOutputDTO {

    private Integer id;
    private String nome;
    private String cognome;
    private String username;
    private IndirizzoOutputDTO residenza;
    private List<ProdottoBasicDTO> prodottiInVendita;

    public VenditoreOutputDTO() {}

    public VenditoreOutputDTO(Integer id, String nome, String cognome, String username) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
    }

    public VenditoreOutputDTO(Integer id, String nome, String cognome, String username, 
                             IndirizzoOutputDTO residenza, List<ProdottoBasicDTO> prodottiInVendita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.residenza = residenza;
        this.prodottiInVendita = prodottiInVendita;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public IndirizzoOutputDTO getResidenza() {
        return residenza;
    }

    public void setResidenza(IndirizzoOutputDTO residenza) {
        this.residenza = residenza;
    }

    public List<ProdottoBasicDTO> getProdottiInVendita() {
        return prodottiInVendita;
    }

    public void setProdottiInVendita(List<ProdottoBasicDTO> prodottiInVendita) {
        this.prodottiInVendita = prodottiInVendita;
    }
}