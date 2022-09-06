package com.library.LibraryProject.model;

import javax.persistence.*;

@Entity
@Table(name = "Book_Table")
public class BookTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @Column(name = "book_name")
    private String book_name;

    @Column(name = "book_count")
    private int book_count;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_key_id")
//    private AuthorTable authorTable;/

    public BookTable() {
    }
    public Long getBook_id() {
        return book_id;
    }
    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public int getBook_count() {
        return book_count;
    }
    public void setBook_count(int book_count) {
        this.book_count = book_count;
    }

//    public AuthorTable getAuthorTable() {
//        return authorTable;
//    }
//    public void setAuthorTable(AuthorTable authorTable) {
//        this.authorTable = authorTable;
//    }
}
