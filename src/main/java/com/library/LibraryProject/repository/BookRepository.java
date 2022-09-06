package com.library.LibraryProject.repository;

import com.library.LibraryProject.model.BookTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Baza bilan qanday amallar bajarilishi
@Repository
public interface BookRepository extends JpaRepository<BookTable, Long> {
}
