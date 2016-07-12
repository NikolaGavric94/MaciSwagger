package com.maci.service;

import java.util.List;

import com.maci.entity.Student;

public interface StudentService {
	
	public int getCount();
	
	public List<Student> getAllStudents();
	
	public boolean addStudent(Student student);
	
	public List<Student> getStudentsBySubject(int subjectId);
}
