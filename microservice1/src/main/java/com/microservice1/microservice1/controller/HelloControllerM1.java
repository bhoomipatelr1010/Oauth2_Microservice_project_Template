package com.microservice1.microservice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice1.microservice1.configuration.M1Configuration;
import com.microservice1.microservice1.data.PropertyData;

@RestController
@RequestMapping("m1")
public class HelloControllerM1 {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private M1Configuration m1Configuration;

	@GetMapping
	public ResponseEntity<String> get() {
		ResponseEntity<String> res = new ResponseEntity<String>("Hi from M1", HttpStatus.OK);
		return res;
	}

	@GetMapping("property/thirdpaty")
	public ResponseEntity<PropertyData> fetchThirdPartyProperty() {

		ResponseEntity<PropertyData> res = restTemplate.getForEntity("http://localhost:8088/m2/property/own",
				PropertyData.class);
		return res;
	}

	@GetMapping("property/own")
	public ResponseEntity<PropertyData> fetchOwnProperty() {

		PropertyData data = new PropertyData();
		data.setData(m1Configuration.getData());
		data.setLimit(m1Configuration.getLimit());
		ResponseEntity<PropertyData> res = new ResponseEntity<PropertyData>(data, HttpStatus.OK);
		return res;
	}
}
