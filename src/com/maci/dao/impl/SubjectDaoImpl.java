package com.maci.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.maci.dao.SubjectDao;
import com.maci.entity.Subject;
import com.maci.mapper.SubjectMapper;

public class SubjectDaoImpl implements SubjectDao{

	private JdbcTemplate jdbcTemplate;
	@SuppressWarnings("unused")
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
				"(NAZIV) VALUES (?)";
		jdbcTemplate.update(sql, new Object[] {subject.getNaziv()});
		return true;
	}

	@Override
	public List<Subject> getSubjectsByStudent(int studentId) {
		String sql= "SELECT SUBJECTS.ID, SUBJECTS.NAZIV FROM STUDENT_SUBJECT  "+
				"JOIN SUBJECTS ON STUDENT_SUBJECT.PREDMET_ID=SUBJECTS.ID "+
				"WHERE STUDENT_ID="+studentId;
		List<Subject> subjects= jdbcTemplate.query(sql, new SubjectMapper());
		return subjects;
	}

}
