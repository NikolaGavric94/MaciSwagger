package com.maci.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.maci.dao.SubjectDao;
import com.maci.service.SubjectService;

public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public int getCount() {
		return subjectDao.getCount(); 
	}

}
