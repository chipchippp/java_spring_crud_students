package com.spring.crud_students.service;

import com.spring.crud_students.entity.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    public List<ClassRoom> findAll();
    public ClassRoom findById(Long id);
    public ClassRoom save(ClassRoom classRoom);
    public void update(ClassRoom classRoom);
//    saveAndFlush
    public void delete(Long id);
    public List<ClassRoom> getAllClassRoomByNotName(String name);
}
