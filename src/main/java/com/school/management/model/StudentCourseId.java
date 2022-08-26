package com.school.management.model;

import java.io.Serializable;
import java.util.Objects;

public class StudentCourseId implements Serializable {
    private Long idCourse;
    private Long idStudent;

    public StudentCourseId(){
    }

    public StudentCourseId(Long idCourse, Long idStudent) {
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentCourseId)) return false;
        StudentCourseId that = (StudentCourseId) o;
        return idCourse.equals(that.idCourse) && idStudent.equals(that.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, idStudent);
    }
}
