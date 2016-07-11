package com.maci.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.maci.entity.Subject;

public class SubjectMapper implements RowMapper<Subject>{

	@Override
	public Subject mapRow(ResultSet rs, int arg1) throws SQLException{
		
		Subject subject = new Subject();
		subject.setId(rs.getInt("id"));
		subject.setNaziv(rs.getString("naziv"));
		return subject;
	}
}
