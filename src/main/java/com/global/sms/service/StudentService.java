package com.global.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.sms.entity.Student;
import com.global.sms.repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepo studentRepo;

	public Student findById(Long id) {
		return studentRepo.findById(id).orElseThrow();
	}

	public Student getById(Long id) {
		return studentRepo.getReferenceById(id);
	}

	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	public Long count() {
		return studentRepo.count();
	}

	public Student insert(Student student) {
		return studentRepo.save(student);
	}

	public Student update(Student student) {
		Student updated = getById(student.getId());
		updated.setFirstName(student.getFirstName());
		updated.setLastName(student.getLastName());
		updated.setEmail(student.getEmail());
		return studentRepo.save(updated);
	}

	public void deleteById(Long id) {
		studentRepo.deleteById(id);
	}

}
