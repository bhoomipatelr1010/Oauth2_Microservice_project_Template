package com.microservice2.microservice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice2.microservice2.configuration.M2Configuration;
import com.microservice2.microservice2.data.PropertyData;

@RestController
@RequestMapping("m2")
public class HelloControllerM2 {

	@Autowired
	private M2Configuration m2Configuration;

	@GetMapping
	public ResponseEntity<String> get() {
		ResponseEntity<String> res = new ResponseEntity<String>("Hi from M2", HttpStatus.OK);
		return res;
	}

	@GetMapping("property/own")
	public ResponseEntity<PropertyData> fetchOwnProperty() {

		PropertyData data = new PropertyData();
		data.setData(m2Configuration.getData());
		data.setLimit(m2Configuration.getLimit());
		ResponseEntity<PropertyData> res = new ResponseEntity<PropertyData>(data, HttpStatus.OK);
		return res;
	}
}
