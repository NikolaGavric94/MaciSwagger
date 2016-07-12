package com.maci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maci.dao.SubjectDao;
import com.maci.entity.Subject;
import com.maci.service.SubjectService;

public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public int getCount() {
		return subjectDao.getCount(); 
	}

	@Override
	public List<Subject> getAllSubject() {
		return subjectDao.getAllSubject();
	}

	@Override
	public boolean addSubject(Subject subject) {
		return subjectDao.addSubject(subject);
	}

	@Override
	public List<Subject> getSubjectsByStudent(int studentId) {
		return subjectDao.getSubjectsByStudent(studentId);
	}

}
