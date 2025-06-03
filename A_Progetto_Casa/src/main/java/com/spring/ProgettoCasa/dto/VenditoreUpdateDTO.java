package com.spring.ProgettoCasa.dto;

import jakarta.validation.constraints.*;
public class VenditoreUpdateDTO {

    @Size(min = 3, max = 50, message = "L'username deve essere tra 3 e 50 caratteri")
    private String username;

    @Size(max = 100, message = "Il nome non può superare 100 caratteri")
    private String nome;

    @Size(max = 100, message = "Il cognome non può superare 100 caratteri")
    private String cognome;

    public VenditoreUpdateDTO() {}

    public VenditoreUpdateDTO(String username) {
        this.username = username;
    }

    public VenditoreUpdateDTO(String nome, String cognome, String username) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
    }

    // Getter e Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
