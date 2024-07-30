package com.telusko.BackEndSMProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.BackEndSMProject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
