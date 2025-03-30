package com.spring.banca.dto;

public class ErroreDTO {
    private String messaggio;

    public ErroreDTO(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
}
