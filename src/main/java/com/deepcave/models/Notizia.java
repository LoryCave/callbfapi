package com.deepcave.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class Notizia {
    private Integer id;
    private String titolo;
    private String contenuto;
    private String creazione;
    private String image;
    private String message;

    public Notizia(String titolo, String contenuto, String creazione, String image, String message) {
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.creazione = creazione;
        this.image = image;
        this.message = message;
    }

    public Notizia() {
    }
}
