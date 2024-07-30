package com.telusko.BackEndSMProject.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.BackEndSMProject.dao.StudentRepository;
import com.telusko.BackEndSMProject.model.Student;


@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student getStudentByiD(Long id) {
		
		return repo.findById(id).
				orElseThrow(()-> new NoSuchElementException("Student not found"+id));
	}



	@Override
	public Student updateStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		repo.deleteById(id);

	}

}
