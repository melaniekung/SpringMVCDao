package com.csis3275.dao_mku_03;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model_mku_03.StudentMapper_mku_03;
import com.csis3275.model_mku_03.Student_mku_03;

@Component
public class StudentDAOImpl_mku_03 {
	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL = "SELECT * FROM students;";
	private final String SQL_CREATE_STUDENT = "INSERT INTO students(name, email) VALUES (?,?)";
	private final String SQL_DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
	private final String SQL_UPDATE_STUDENT = "UPDATE students SET name = ?, email = ? WHERE id = ?";
	
	@Autowired
	public StudentDAOImpl_mku_03(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Student_mku_03> getAllStudents() {
		return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper_mku_03());
	}

	public boolean createStudent(Student_mku_03 student) {
		return jdbcTemplate.update(SQL_CREATE_STUDENT, student.getName(), student.getEmail()) > 0;
	}

	public boolean deleteStudent(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT, idToDelete) > 0;
	}
	
	public boolean editStudent(Student_mku_03 student) {
		return jdbcTemplate.update(SQL_UPDATE_STUDENT, student.getName(), student.getEmail(), student.getId()) > 0;
	}

}
