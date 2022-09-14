package com.library.LibraryProject.controller;

import com.library.LibraryProject.model.StudentTable;
import com.library.LibraryProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class StudendController {
    private final StudentService studentService;

    public StudendController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student-post")
    public ResponseEntity<?> studentPost(
        @RequestParam(name = "login") String login,
        @RequestParam(name = "password") int password,
        @RequestParam(name = "email") String email
    ){
        StudentTable studentTable1 = new StudentTable();
        studentTable1.setLogin(login);
        studentTable1.setPassword(password);
        studentTable1.setEmail(email);
        return ResponseEntity.ok(studentService.save(studentTable1));
    }

    @PutMapping("/student-put")
    public ResponseEntity<?> studentPut(@RequestBody StudentTable studentTable){
        return ResponseEntity.ok(studentService.save(studentTable));
    }

    @GetMapping("/student")
    public ResponseEntity<?> studentGet(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> studentGetId(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/student-del/{id}")
    public ResponseEntity<?> studentDel(@PathVariable Long id){
        try{
            studentService.delete(id);
        }
        catch (NoSuchElementException e){
            return ResponseEntity.ok("Unday ma'lumot mavjud emas!");
        }
        return ResponseEntity.ok("Deleted");
    }
}
