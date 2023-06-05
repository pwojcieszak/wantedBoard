package com.example.wantedBoard.model;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class Criminal implements Serializable {
    private String title;
    private String description;
    private String caution;

    public Criminal() {
    }

    public Criminal(String title, String description, String caution) {
        this.title = title;
        this.description = description;
        this.caution = caution;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", caution='" + caution + '\'' +
                '}';
    }
}
