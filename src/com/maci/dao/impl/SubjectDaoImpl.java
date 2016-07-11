package com.maci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.maci.dao.SubjectDao;
import com.maci.entity.Student;
import com.maci.entity.Subject;
import com.maci.mapper.SubjectMapper;

public class SubjectDaoImpl implements SubjectDao{

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Transactional
	public int getCount() {
		String sql = "SELECT COUNT(*) FROM SUBJECTS";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	@Transactional
	public List<Subject> getAllSubject() {
		String sql= "SELECT * FROM SUBJECTS";
		List<Subject> subjects= jdbcTemplate.query(sql, new SubjectMapper());
		return subjects;
	}

	@Override
	@Transactional
	public boolean addSubject(Subject subject) {
		String sql = "INSERT INTO SUBJECTS " +
				"(ID, NAZIV) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { subject.getId(), subject.getNaziv()});
		return true;
	}

}
