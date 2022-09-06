package com.library.LibraryProject.repository;

import com.library.LibraryProject.model.StudentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Baza bilan qanday amallar bajarilishi
@Repository
public interface StudentRepository extends JpaRepository<StudentTable, Long> {
}
