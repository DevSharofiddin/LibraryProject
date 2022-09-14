package com.library.LibraryProject.controller;

import com.library.LibraryProject.model.AuthorTable;
import com.library.LibraryProject.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author-post")
    public ResponseEntity<?> authorPost(@RequestParam(name = "author_name") String author_name){
        AuthorTable authorTable1 = new AuthorTable();
        authorTable1.setAuthor_name(author_name);
        return ResponseEntity.ok(authorService.save(authorTable1));
    }

    @PutMapping("/author-put")
    public ResponseEntity<?> authorPut(@RequestBody AuthorTable authorTable){
        return ResponseEntity.ok(authorService.save(authorTable));
    }

    @GetMapping("/author")
    public ResponseEntity<?> authorGet(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<?> authorGetId(@PathVariable Long id){
        return ResponseEntity.ok(authorService.findById(id));
    }

    @DeleteMapping("/author-del/{id}")
    public ResponseEntity<?> authorDel(@PathVariable Long id){
        try {
            authorService.delete(id);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.ok("Unday ma'lumot mavjud emas!");
        }
        return ResponseEntity.ok("Deleted");
    }
}
