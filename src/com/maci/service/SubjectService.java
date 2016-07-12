package com.maci.service;

import java.util.List;

import com.maci.entity.Student;
import com.maci.entity.Subject;

public interface SubjectService {
	
	public int getCount();
	
	public List<Subject> getAllSubject();
	
	public boolean addSubject(Subject subject);
	
	public List<Subject> getSubjectsByStudent(int studentId);


}
