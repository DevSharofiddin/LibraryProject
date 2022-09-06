package com.library.LibraryProject.service;

import com.library.LibraryProject.model.StudentTable;
import com.library.LibraryProject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Ma'lumotti bazaga saqlash mexanizimi
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // Bazaga ma'lumot qo`shish(Post) methodi...
    public StudentTable save(StudentTable studentTable){
        return studentRepository.save(studentTable);
    }
    // Bazadagi ma'lumotni o`qish(Get)
    public List<StudentTable> findAll(){
        return studentRepository.findAll();
    }
    // Bazadan id orqali bitta ma'lumotni ko`rish
    public StudentTable findById(Long id){
        return studentRepository.findById(id).get();
    }
    // Bazadan id orqali ma'lumotni o`chirish
    public void delete(Long id){
        studentRepository.delete(findById(id));
    }
}
