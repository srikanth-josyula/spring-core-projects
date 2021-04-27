package com.operations.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.operations.dao.PersonDAO;
import com.operations.entities.PersonEntity;

@Repository(value = "personDAO")
public class PersonDAOImpl implements PersonDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(PersonEntity prs) {
		String query = "INSERT INTO PERSONENTITY(PERSONID, PERSONNAME, EMAIL) values(?,?,?)";
		jdbcTemplate.update(query, new Object[] { prs.getPersonId(), prs.getPersonName(), prs.getEmail() });
	}

	@Override
	public int delete(int empid) {
		return jdbcTemplate.update("DELETE FROM PERSONENTITY WHERE PERSONID = ? ", empid);
	}

	@Override
	public List<PersonEntity> getAll() {
		String sql = "SELECT PERSONID, PERSONNAME, EMAIL FROM PERSONENTITY";
		return jdbcTemplate.query(sql, new RowMapper<PersonEntity>() {
			public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonEntity emp = new PersonEntity();
				emp.setPersonId(rs.getInt("PersonId"));
				emp.setPersonName(rs.getString("PersonName"));
				emp.setEmail(rs.getString("Email"));
				return emp;
			}
		});
	}

	@Override
	public PersonEntity get(int PersonId) {
		String sql = "SELECT PERSONID, PERSONNAME, EMAIL FROM PERSONENTITY WHERE PERSONID=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { PersonId }, new RowMapper<PersonEntity>() {
			public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonEntity emp = new PersonEntity();
				emp.setPersonId(rs.getInt("PersonId"));
				emp.setPersonName(rs.getString("PersonName"));
				emp.setEmail(rs.getString("Email"));
				return emp;
			}
		});
	}

	public int getCount() {
		String sql = "SELECT COUNT(*) FROM PERSONENTITY";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int update(int PersonId, String PersonName) {
		String query = "UPDATE PERSONENTITY SET PERSONNAME = ? " + " WHERE PERSONID = ?";
		return jdbcTemplate.update(query, PersonName, PersonId);
	}

}
