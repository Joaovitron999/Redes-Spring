package com.school.management.repository;

import com.school.management.model.Course;
import com.school.management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
