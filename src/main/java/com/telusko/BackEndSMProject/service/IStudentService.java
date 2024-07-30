package com.telusko.BackEndSMProject.service;

import java.util.List;

import com.telusko.BackEndSMProject.model.Student;

public interface IStudentService {
	
	
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student getStudentByiD(Long id);
	public Student updateStudent(Student student);
	public void deleteStudentById(Long id);

}
