package com.school.management.service;
import com.school.management.model.Student;
import com.school.management.model.StudentCourse;
import com.school.management.model.dto.CourseDto;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.StudentCourseRepository;
import com.school.management.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentCourseService(StudentCourseRepository studentCourseRepository, StudentService studentService, CourseService courseService, StudentRepository studentRepository, CourseRepository courseRepository) {
        //injeção dependência
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;



        this.courseRepository = courseRepository;
    };
    public List<CourseDto> getCoursesFromStudent(long id){
        ArrayList<CourseDto> aaa = new ArrayList<CourseDto>();
        ArrayList<StudentCourse> bbb = new ArrayList<StudentCourse>();
        studentCourseRepository.findAllByIdStudent(id).forEach(studentCourse -> bbb.add(studentCourse));

        Iterator<StudentCourse> it = bbb.iterator();
        while(it.hasNext()) {
            CourseDto x = new CourseDto();
            x.setId(it.next().getIdCourse());
            aaa.add(x);
            System.out.println(it.next().getIdCourse());
        }



        return aaa;
    }

    public void cadCoursesStudent(Long id, List<Long> courseIds) {
        ArrayList<StudentCourse> studentCourses = new ArrayList<>();
        if(courseIds.size()>5)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "can't 5 or more courses for student");
        //optional
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"student not found"));
        courseIds.forEach(course -> {
            courseRepository.findById(course).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not Found"));
            studentCourses.add(new StudentCourse(id,course));
        });
        studentCourseRepository.saveAll(studentCourses);

    }
}
