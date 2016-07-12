package com.maci.dao;

import java.util.List;

import com.maci.entity.Student;
import com.maci.entity.StudentSubject;

public interface StudentDao {
	
	public int getCount();
	
	public List<Student> getAllStudents();
	
	public boolean addStudent(Student student);
	
	public List<Student> getStudentsBySubject(int subjectId);
	
	public boolean addGrade(StudentSubject object);
}
