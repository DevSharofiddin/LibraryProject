package com.library.LibraryProject.service;

import com.library.LibraryProject.model.AuthorTable;
import com.library.LibraryProject.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Ma'lumotti bazaga saqlash mexanizimi
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    // Bazaga ma'lumot qo`shish(Post) methodi...
    public AuthorTable save(AuthorTable authorTable){
        return authorRepository.save(authorTable);
    }
    // Bazadagi ma'lumotni o`qish(Get)
    public List<AuthorTable> findAll(){
        return authorRepository.findAll();
    }
    // Bazadan id orqali bitta ma'lumotni ko`rish
    public AuthorTable findById(Long id){
        return authorRepository.findById(id).get();
    }
    // Bazadan id orqali ma'lumotni o`chirish
    public void delete(Long id){
        authorRepository.delete(findById(id));
    }
}
