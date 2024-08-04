package com.deepcave.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Content {
    private String content;
    private List<Embed> embeds;

    public Content(String content, List<Embed> embeds) {
        this.content = content;
        this.embeds = embeds;
    }
}
