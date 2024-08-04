package com.deepcave.models.discord;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Message {
    private float type;
    private String content;
    ArrayList<Object> mentions = new ArrayList<>();
    ArrayList<Object> mention_roles = new ArrayList<>();
    ArrayList<Object> attachments = new ArrayList<>();
    ArrayList<Object> embeds = new ArrayList<>();
    private String timestamp;
    private float flags;
    ArrayList<Object> components = new ArrayList<>();
    private String id;
    private String channel_id;
    Object AuthorObject;
    private boolean pinned;
    private boolean mention_everyone;
    private boolean tts;
}
