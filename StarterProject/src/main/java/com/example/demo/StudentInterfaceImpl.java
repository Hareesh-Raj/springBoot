package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ss")
public class StudentInterfaceImpl implements StudentInterface{
	@Autowired
	StudentDAO dao;

	@Override
	public void createStudent(StudentDTO student) {
		dao.save(student);
	}
	
}
