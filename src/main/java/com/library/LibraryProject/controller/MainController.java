package com.library.LibraryProject.controller;

import com.library.LibraryProject.model.AuthorTable;
import com.library.LibraryProject.model.BookTable;
import com.library.LibraryProject.model.StudentTable;
import com.library.LibraryProject.service.AuthorService;
import com.library.LibraryProject.service.BookService;
import com.library.LibraryProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class MainController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final StudentService studentService;

    public MainController(AuthorService authorService, BookService bookService, StudentService studentService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.studentService = studentService;
    }

// Post methods...
    @PostMapping("/authorpost")
    public ResponseEntity authorPost(@RequestBody AuthorTable authorTable){
        AuthorTable authorTable1 = authorService.save(authorTable);
        return ResponseEntity.ok(authorTable1);
    }
    @PostMapping("/bookpost")
    public ResponseEntity bookPost(@RequestBody BookTable bookTable){
        BookTable bookTable1 = bookService.save(bookTable);
        return ResponseEntity.ok(bookTable1);
    }
    @PostMapping("/studentpost")
    public ResponseEntity studentPost(@RequestBody StudentTable studentTable){
        StudentTable studentTable1 = studentService.save(studentTable);
        return ResponseEntity.ok(studentTable1);
    }

// Get methods...
    @GetMapping("/authorget")
    public ResponseEntity authorGet(){
        return ResponseEntity.ok(authorService.findAll());
    }
    @GetMapping("/bookget")
    public ResponseEntity bookGet(){
        return ResponseEntity.ok(bookService.findAll());
    }
    @GetMapping("/studentget")
    public ResponseEntity studentGet(){
        return ResponseEntity.ok(studentService.findAll());
    }

// GetOneById methods...
    @GetMapping("/authorget/{id}")
    public ResponseEntity authorGetId(@PathVariable Long id){
        return ResponseEntity.ok(authorService.findById(id));
    }
    @GetMapping("/bookget/{id}")
    public ResponseEntity bookGetId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }
    @GetMapping("/studentget/{id}")
    public ResponseEntity studentGetId(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

// Update methods...
    @PutMapping("/authorput")
    public ResponseEntity authorPut(@RequestBody AuthorTable authorTable){
        return ResponseEntity.ok(authorService.save(authorTable));
    }
    @PutMapping("/bookput")
    public ResponseEntity bookPut(@RequestBody BookTable bookTable){
        return ResponseEntity.ok(bookService.save(bookTable));
    }
    @PutMapping("/studentput")
    public ResponseEntity studentPut(@RequestBody StudentTable studentTable){
        return ResponseEntity.ok(studentService.save(studentTable));
    }

// Delete methods...
    @DeleteMapping("/authordel/{id}")
    public ResponseEntity authorDel(@PathVariable Long id){
        try {
            authorService.delete(id);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.ok("Unday ma'lumot mavjud emas!");
        }
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping("/bookdel/{id}")
    public ResponseEntity bookDel(@PathVariable Long id){
        try{
        bookService.delete(id);
        }
        catch (NoSuchElementException e){
                return ResponseEntity.ok("Unday ma'lumot mavjud emas!");
        }
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping("/studentdel/{id}")
    public ResponseEntity studentDel(@PathVariable Long id){
        try{
            studentService.delete(id);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.ok("Unday ma'lumot mavjud emas!");
        }
        return ResponseEntity.ok("Deleted");
    }
}