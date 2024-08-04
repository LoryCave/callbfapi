package com.deepcave.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Embed {
    private String titolo;
    private String description;
    private Integer color;

    public Embed(String titolo, String description, Integer color) {
        this.titolo = titolo;
        this.description = description;
        this.color = color;
    }
}
