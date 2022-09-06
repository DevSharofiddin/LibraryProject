package com.library.LibraryProject.service;

import com.library.LibraryProject.model.BookTable;
import com.library.LibraryProject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Ma'lumotti bazaga saqlash mexanizimi
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    // Bazaga ma'lumot qo`shish(Post) methodi...
    public BookTable save(BookTable bookTable){
        return bookRepository.save(bookTable);
    }
    // Bazadagi ma'lumotni o`qish(Get)
    public List<BookTable> findAll(){
        return bookRepository.findAll();
    }
    // Bazadan id orqali bitta ma'lumotni ko`rish
    public BookTable findById(Long id){
        return bookRepository.findById(id).get();
    }
    // Bazadan id orqali ma'lumotni o`chirish
    public void delete(Long id){
        bookRepository.delete(findById(id));
    }
}
