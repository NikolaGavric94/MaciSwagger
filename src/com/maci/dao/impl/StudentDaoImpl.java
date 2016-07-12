package com.maci.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.maci.dao.StudentDao;
import com.maci.entity.Student;
import com.maci.entity.StudentSubject;
import com.maci.mapper.StudentMapper;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	@SuppressWarnings("unused")
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


	@Override
	public List<Student> getStudentsBySubject(int subjectId) {
		String sql= "SELECT STUDENTS.ID, IME, PREZIME FROM STUDENT_SUBJECT "+
					"JOIN STUDENTS ON STUDENT_SUBJECT.STUDENT_ID=STUDENTS.ID "+
					"WHERE PREDMET_ID="+subjectId;
		List<Student> students= jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}


	@Override
	public boolean addGrade(StudentSubject object) {
		String sql = "INSERT INTO STUDENT_SUBJECT " +
				"(STUDENT_ID, PREDMET_ID, OCENA) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {object.getStudent_id(), object.getPredmet_id(), object.getOcena()});
		System.out.println(sql);
		return true;
	}
	
}
