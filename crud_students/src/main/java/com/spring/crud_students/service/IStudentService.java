package com.spring.crud_students.service;

import com.spring.crud_students.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student findById(Long id);
    public Student save(Student student);
    public void update(Student student);
    public void delete(Long id);

}
