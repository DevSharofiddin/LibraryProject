package com.library.LibraryProject.model;

import javax.persistence.*;

@Entity
@Table(name = "Author_table")
public class AuthorTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;

    @Column(name = "author_name")
    private String author_name;

    public AuthorTable() {

    }
    public Long getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
