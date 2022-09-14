package com.library.LibraryProject.controller;

import com.library.LibraryProject.model.AuthorTable;
import com.library.LibraryProject.model.BookTable;
import com.library.LibraryProject.service.AuthorService;
import com.library.LibraryProject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping("/book-post")
    public ResponseEntity<?> bookPost(
            @RequestParam(name = "book_name") String bookName,
            @RequestParam(name = "book_count") int bookCount,
            @RequestParam(name = "author_id") Long authorID
    ){
        AuthorTable author = authorService.findById(authorID);
        BookTable bookTable1 = new BookTable();

        bookTable1.setBook_name(bookName);
        bookTable1.setBook_count(bookCount);
        bookTable1.setAuthor(author);
        
        return ResponseEntity.ok(bookService.save(bookTable1));
    }

    @PutMapping("/book-put")
    public ResponseEntity<?> bookPut(
            @RequestParam(name = "book_id") Long book_id,
            @RequestParam(name = "book_name") String book_name,
            @RequestParam(name = "book_count") int book_count,
            @RequestParam(name = "author_id") Long authorID
    ){
        AuthorTable authorTable1 = authorService.findById(authorID);
        BookTable bookTable1 = bookService.findById(book_id);

        bookTable1.setBook_name(book_name);
        bookTable1.setBook_count(book_count);
        bookTable1.setAuthor(authorTable1);

        return ResponseEntity.ok(bookService.save(bookTable1));
    }

    @GetMapping("/book")
    public ResponseEntity<?> bookGet(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> bookGetId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/book-del/{id}")
    public ResponseEntity<?> bookDel(@PathVariable Long id){
        try{
            bookService.delete(id);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.ok("Unday ma'lumot mavjud emas!");
        }
        return ResponseEntity.ok("Deleted");
    }
}
