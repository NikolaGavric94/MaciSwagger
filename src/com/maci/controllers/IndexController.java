package com.maci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maci.service.SubjectService;


@RestController
public class IndexController {
	
	@Autowired
	SubjectService subjectService;
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getSubjectCount() {

		int i = subjectService.getCount();
		return new ResponseEntity<String>("Broj predmeta je: " + i, HttpStatus.OK);

	}
}
