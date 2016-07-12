package com.maci.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.maci.dao.StudentDao;
import com.maci.entity.Student;
import com.maci.entity.Subject;
import com.maci.mapper.StudentMapper;
import com.maci.mapper.SubjectMapper;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public int getCount() {
		String sql = "SELECT COUNT(*) FROM STUDENTS";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}


	@Override
	public List<Student> getAllStudents() {
		String sql= "SELECT * FROM STUDENTS";
		List<Student> students= jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}


	@Override
	@Transactional
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO STUDENTS " +
				"(IME, PREZIME) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] {student.getIme(), student.getPrezime()});
		return true;
	}
	
}
