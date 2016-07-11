package com.maci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maci.entity.Student;
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

		List<Subject> subjects = subjectService.getAllSubject();
		return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);

	}
	
	@RequestMapping(value="/subCount", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getSubjectCount() {
		int i = subjectService.getCount();
		return new ResponseEntity<String>("Broj predmeta je: " + i, HttpStatus.OK);

	}
	
	@RequestMapping(value="/addSubject", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Subject> addSubject() {
		Subject toSave= new Subject();
		return new ResponseEntity<Subject>(toSave, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addSubject", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addSubject(@RequestParam Subject s, @RequestParam int id) {
		subjectService.addSubject(s);
		return new ResponseEntity<String>("Objekat je sacuvan"+id, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/students", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentCount", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getStudentCount() {
		return new ResponseEntity<String>("Broj studenata je: " + studentService.getCount(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addStudent", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Student> addStudent() {
		Student toSave= new Student();
		return new ResponseEntity<Student>(toSave, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addStudent", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addStudent(@RequestParam Student s, @RequestParam int id) {
		studentService.addStudent(s);
		return new ResponseEntity<String>("Objekat je sacuvan"+id, HttpStatus.OK);
	}
}
