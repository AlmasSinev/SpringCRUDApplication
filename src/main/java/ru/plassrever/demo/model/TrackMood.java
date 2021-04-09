package ru.plassrever.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="mood")
public class TrackMood {

    @Id
    @Column(name = "mood_id")
    private int id;

    @Column(name = "mood_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
