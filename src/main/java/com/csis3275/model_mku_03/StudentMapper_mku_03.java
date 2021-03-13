package com.csis3275.model_mku_03;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper_mku_03 implements RowMapper<Student_mku_03> {
	public Student_mku_03 mapRow(ResultSet resultSet, int i) throws SQLException {
		Student_mku_03 student = new Student_mku_03();
		student.setId(resultSet.getInt("id"));
		student.setEmail(resultSet.getString("email"));
		student.setName(resultSet.getString("name"));
		
		return student;
	}
}
