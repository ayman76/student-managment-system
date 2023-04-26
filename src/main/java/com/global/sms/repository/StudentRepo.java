package com.global.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.sms.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
