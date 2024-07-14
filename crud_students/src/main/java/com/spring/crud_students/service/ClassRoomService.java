package com.spring.crud_students.service;

import com.spring.crud_students.entity.ClassRoom;
import com.spring.crud_students.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService{
    private final ClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom findById(Long id) {
        return classRoomRepository.findById(id).orElse(null);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public void update(ClassRoom classRoom) {
        ClassRoom classRoom1 = classRoomRepository.findById(classRoom.getId()).orElse(null);
        if (classRoom1 != null) {
            classRoom1.setId(classRoom.getId());
            classRoom1.setName(classRoom.getName());
            classRoom1.setNumberRoom(classRoom.getNumberRoom());
            classRoomRepository.save(classRoom1);
        }
    }

    @Override
    public void delete(Long id) {
        classRoomRepository.deleteById(id);
    }

    @Override
    public List<ClassRoom> getAllClassRoomByNotName(String name) {
        return classRoomRepository.findByNameNot(name);
    }

//    public List<StudentClass> getAllStudentClass() {
//        // Your implementation here
//    }
}
