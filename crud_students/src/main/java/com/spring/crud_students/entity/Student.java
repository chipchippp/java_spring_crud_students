package com.spring.crud_students.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
@NamedStoredProcedureQuery(
        name = "SP_GET_ALL_STUDENTS",
        procedureName = "SP_GET_ALL_STUDENTS",
        resultClasses = Student.class
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "email", unique = true, length = 50)
    private String email;
    @Column(name = "phone", length = 11)
    private String phone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(String name, String email, String phone, ClassRoom classRoom) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
