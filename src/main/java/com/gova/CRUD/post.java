package com.gova.CRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class post {


    @Id
    Long id;

    String author;
    String content;


    public post() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    

    
}
