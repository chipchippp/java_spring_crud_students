package com.spring.crud_students.controller;


import com.spring.crud_students.entity.ClassRoom;
import com.spring.crud_students.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping
    public List<ClassRoom> getAllClassRoom() {
        return classRoomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> getClassRoomById(@PathVariable Long id) {
        ClassRoom classRoom = classRoomService.findById(id);
        if (classRoom != null) {
            return ResponseEntity.ok(classRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClassRoom> addClassRoom(@RequestBody ClassRoom classRoom) {
        classRoom.setId(0L);
        classRoom = classRoomService.save(classRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(classRoom);
    }

    @PutMapping("/{id}")
    public void updateClassRoom(@RequestBody ClassRoom classRoom) {
        classRoomService.update(classRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable Long id) {
        try {
            classRoomService.delete(id);
            return new ResponseEntity<>("Delete operation is successful.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Error: No ClassRoom with the provided id found.", HttpStatus.NOT_FOUND);
        }
    }
}