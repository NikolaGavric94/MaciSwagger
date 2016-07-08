package com.maci.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping(value="/main", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getIndex() {
		return new ResponseEntity<String>("#YOLO", HttpStatus.OK);
	}
}
