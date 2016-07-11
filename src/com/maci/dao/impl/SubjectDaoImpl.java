package com.maci.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maci.dao.SubjectDao;

//@Repository
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

}
