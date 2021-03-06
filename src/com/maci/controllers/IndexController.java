package com.maci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maci.entity.Student;
import com.maci.entity.StudentSubject;
import com.maci.entity.Subject;
import com.maci.service.StudentService;
import com.maci.service.SubjectService;


@RestController
public class IndexController {
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/subjects", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Subject>> getSubjects() {
		return new ResponseEntity<List<Subject>>(subjectService.getAllSubject(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/countSubject", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getSubjectCount() {
		return new ResponseEntity<String>("Broj predmeta je: " + subjectService.getCount(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addSubject", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addSubject(@RequestBody Subject subject) {
		subjectService.addSubject(subject);
		return new ResponseEntity<String>("Objekat je sacuvan" , HttpStatus.OK);
	}
		
	@RequestMapping(value="/students", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Student>> getStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/countStudent", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getStudentCount() {
		return new ResponseEntity<String>("Broj studenata je: " + studentService.getCount(), HttpStatus.OK);
	}

	@RequestMapping(value="/addStudent", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return new ResponseEntity<String>("Objekat je sacuvan", HttpStatus.OK);
	}
	
	@RequestMapping(value="/students/{subjectId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Student>> getStudentsBySubjectId(@PathVariable(value = "subjectId") Integer subjectId) {
		return new ResponseEntity<List<Student>>(studentService.getStudentsBySubject(subjectId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/subjects/{studentId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Subject>> getSubjectsByStudentId(@PathVariable(value = "studentId") Integer studentId) {
		return new ResponseEntity<List<Subject>>(subjectService.getSubjectsByStudent(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addGrade", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<String> addGrade(@RequestBody StudentSubject studentSubject) {
		studentService.addGrade(studentSubject);
		return new ResponseEntity<String>("Objekat je sacuvan" , HttpStatus.OK);
	}
}
