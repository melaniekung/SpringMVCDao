package com.csis3275.controller_mku_03;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_mku_03.StudentDAOImpl_mku_03;
import com.csis3275.model_mku_03.Student_mku_03;

@Controller
public class StudentController_mku_03 {
	@Autowired
	StudentDAOImpl_mku_03 studentDaoImpl;

	@ModelAttribute("student")
	public Student_mku_03 setupAddForm() {
		return new Student_mku_03();
	}

	@GetMapping("/showStudents")
	public String showStudents(HttpSession session, Model model) {
		List<Student_mku_03> students = studentDaoImpl.getAllStudents();

		model.addAttribute("students", students);
		model.addAttribute("student", new Student_mku_03());

		return "showStudents";
	}

	@PostMapping("/createStudent")
	public String createStudent(@ModelAttribute("student") Student_mku_03 createStudent, Model model) {
		studentDaoImpl.createStudent(createStudent);
		List<Student_mku_03> students = studentDaoImpl.getAllStudents();
		model.addAttribute("students", students);

		return "showStudents";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam(required = true) int id, Model model) {
		studentDaoImpl.deleteStudent(id);
		List<Student_mku_03> students = studentDaoImpl.getAllStudents();
		model.addAttribute("students", students);
		model.addAttribute("message", "Deleted Student: " + id);

		return "showStudents";
	}

	@PostMapping("/editStudent")
	public String editStudent(@ModelAttribute("student") Student_mku_03 editStudent, Model model) {
		studentDaoImpl.editStudent(editStudent);
		List<Student_mku_03> students = studentDaoImpl.getAllStudents();
		model.addAttribute("students", students);

		return "showStudents";
	}
}
