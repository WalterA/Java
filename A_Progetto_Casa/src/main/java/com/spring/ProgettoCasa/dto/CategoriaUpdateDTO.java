package com.spring.ProgettoCasa.dto;

import jakarta.validation.constraints.*;
//CategoriaUpdateDTO - per modifiche
public class CategoriaUpdateDTO {
    
    @NotBlank(message = "Il nome della categoria non può essere vuoto")
    @Size(max = 100, message = "Il nome della categoria non può superare 100 caratteri")
    private String nome;

    public CategoriaUpdateDTO() {}

    public CategoriaUpdateDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
