package com.maci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maci.entity.Student;
import com.maci.entity.Subject;
import com.maci.service.SubjectService;


@RestController
public class IndexController {
	
	@Autowired
	SubjectService subjectService;
	
	
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
}
