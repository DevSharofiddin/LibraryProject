package com.library.LibraryProject.model;
import javax.persistence.*;

@Entity
@Table(name = "Student_Table")
public class StudentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    private String login;

    private int password;

    private String email;

    public StudentTable() {
    }

    public Long getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public Integer getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
