package com.spring.ProgettoCasa.dto;
//CountResponseDTO - per risposte con conteggi
public class CountResponseDTO {
    
    private Long count;
    private String description;

    public CountResponseDTO() {}

    public CountResponseDTO(Long count, String description) {
        this.count = count;
        this.description = description;
    }

    // Getter e Setter
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
