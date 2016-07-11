package com.maci.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maci.entity.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		Student student=new Student();
		student.setId(rs.getLong("id"));
		student.setIme(rs.getString("ime"));
		student.setPrezime(rs.getString("prezime"));
		return student;
	}

}
