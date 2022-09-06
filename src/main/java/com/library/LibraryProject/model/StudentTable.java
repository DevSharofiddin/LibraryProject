package com.library.LibraryProject.model;
import javax.persistence.*;

@Entity
@Table(name = "Student_Table")
public class StudentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "second_name")
    private String surname;

    @Column(name = "groupS")
    private String groupS;

    @Column(name = "telephone_number")
    private String telephone_number;

    public StudentTable() {
    }
    public Long getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getGroupS() {
        return groupS;
    }
    public void setGroupS(String groupS) {
        this.groupS = groupS;
    }
    public String getTelephone_number() {
        return telephone_number;
    }
    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }
}
