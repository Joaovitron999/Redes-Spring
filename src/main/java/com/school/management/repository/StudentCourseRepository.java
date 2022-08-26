package com.school.management.repository;

import com.school.management.model.StudentCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    public List<StudentCourse> findAllByIdStudent(long id);

}
