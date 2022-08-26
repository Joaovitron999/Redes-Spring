package com.school.management.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@IdClass(StudentCourseId.class)
public class StudentCourse {
	@Id
	private Long idStudent;
	@Id
	private Long idCourse;

	private Timestamp createdAt;
	private Timestamp updatedAt;

	public StudentCourse() {
	}


	public StudentCourse(Long idStudent, Long idCourse, Timestamp createdAt, Timestamp updatedAt) {
		this.idStudent = idStudent;
		this.idCourse = idCourse;

		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public StudentCourse(Long id, Long course) {
		this.idCourse =  course;
		this.idStudent = id;
	}


	public void setIdStudent(Long idStudent){
		this.idStudent = idStudent;
	}

	public Long getIdStudent(){
		return idStudent;
	}

	public void setIdCourse(Long idCourse){
		this.idCourse = idCourse;
	}

	public Long getIdCourse(){
		return idCourse;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
