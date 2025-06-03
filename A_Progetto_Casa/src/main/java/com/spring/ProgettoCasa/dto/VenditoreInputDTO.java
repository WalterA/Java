package com.spring.ProgettoCasa.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

public class VenditoreInputDTO {

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(max = 100, message = "Il nome non può superare 100 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(max = 100, message = "Il cognome non può superare 100 caratteri")
    private String cognome;

    @NotBlank(message = "L'username non può essere vuoto")
    @Size(min = 3, max = 50, message = "L'username deve essere tra 3 e 50 caratteri")
    private String username;

    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 8, message = "La password deve essere almeno 8 caratteri")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
             message = "La password deve contenere almeno: 1 minuscola, 1 maiuscola, 1 numero, 1 carattere speciale")
    private String password;

    @Valid
    private IndirizzoInputDTO residenza;

    public VenditoreInputDTO() {}

    public VenditoreInputDTO(String nome, String cognome, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
    }

    public VenditoreInputDTO(String nome, String cognome, String username, String password, IndirizzoInputDTO residenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.residenza = residenza;
    }

    // Getter e Setter
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IndirizzoInputDTO getResidenza() {
        return residenza;
    }

    public void setResidenza(IndirizzoInputDTO residenza) {
        this.residenza = residenza;
    }
}