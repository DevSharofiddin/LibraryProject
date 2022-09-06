package com.library.LibraryProject.repository;

import com.library.LibraryProject.model.AuthorTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Baza bilan qanday amallar bajarilishi
@Repository
public interface AuthorRepository extends JpaRepository<AuthorTable, Long> {
}
