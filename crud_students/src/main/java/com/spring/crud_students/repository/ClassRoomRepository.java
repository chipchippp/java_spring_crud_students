package com.spring.crud_students.repository;

import com.spring.crud_students.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@RepositoryRestResource( path = "classroom")
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

}
