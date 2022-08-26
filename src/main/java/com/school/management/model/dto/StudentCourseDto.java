package com.school.management.model.dto;

import java.sql.Timestamp;
import java.time.Instant;

public class StudentCourseDto {

	private Long idStudent;

	private Long idCourse;

	private Timestamp createdAt;

	private Timestamp updatedAt;


	public StudentCourseDto(){}
	public StudentCourseDto(Long idStudent, Long idCourse) {
		Timestamp ts = Timestamp.from(Instant.now());
		this.idCourse = idCourse;
		this.idStudent = idStudent;
		this.createdAt = ts;
		this.updatedAt = ts;
	}

	public StudentCourseDto(Long idStudent, Long idCourse, Timestamp createdAt, Timestamp updatedAt) {
		this(idStudent, idCourse);
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
