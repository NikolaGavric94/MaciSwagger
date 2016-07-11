package com.maci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maci.dao.StudentDao;
import com.maci.entity.Student;
import com.maci.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public int getCount() {
		return studentDao.getCount();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

}
