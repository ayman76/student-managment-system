package com.global.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.sms.entity.Student;
import com.global.sms.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "students";
	}

	@GetMapping("/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.insert(student);
		return "redirect:/student";
	}

	@GetMapping("/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getById(id));
		return "edit_student";
	}

	@PostMapping("/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student existStudent = studentService.getById(id);
		existStudent.setId(student.getId());
		existStudent.setFirstName(student.getFirstName());
		existStudent.setLastName(student.getLastName());
		existStudent.setEmail(student.getEmail());

		studentService.update(existStudent);

		return "redirect:/student";
	}

	@GetMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
		return "redirect:/student";
	}

}
