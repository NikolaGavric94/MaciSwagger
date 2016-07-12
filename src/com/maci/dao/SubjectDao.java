package com.maci.dao;

import java.util.List;

import com.maci.entity.Subject;

public interface SubjectDao {

	public int getCount();

	public List<Subject> getAllSubject();

	public boolean addSubject(Subject subject);
}
