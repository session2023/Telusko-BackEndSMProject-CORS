package com.telusko.BackEndSMProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.BackEndSMProject.model.Student;
import com.telusko.BackEndSMProject.service.IStudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:5173/")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@GetMapping("/Students")
	public List<Student> getAllStudents(){
		
		return service.getAllStudents();
		
	}
	
	
	
	@PostMapping("/Student")
	public Student registerStudent(@RequestBody Student student){
		
		return service.saveStudent(student);
		
	}
	
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		
		Student st = service.getStudentByiD(id);
//		return new ResponseEntity<Student>(st, HttpStatus.OK); //this and the below are same
		return ResponseEntity.ok(st);
	}
	
	
	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id, @RequestBody Student student){
		
		Student st = service.getStudentByiD(id);
		st.setName(student.getName());
		st.setEmail(student.getEmail());
		st.setFathersName(student.getFathersName());
		st.setAddress(student.getAddress());
		st.setClassName(student.getClassName());
		st.setPhoneNumber(student.getPhoneNumber());
		
		Student updatedData = service.updateStudent(student);
		
//		return new ResponseEntity<Student>(updatedData, HttpStatus.OK); //this and the below are same
		return ResponseEntity.ok(st);

	}
	
	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable Long id){
		
		service.deleteStudentById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	

}
