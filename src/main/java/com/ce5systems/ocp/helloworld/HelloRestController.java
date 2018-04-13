package com.ce5systems.ocp.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class HelloRestController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello() {

		String greeting = "John";

		return new ResponseEntity<String>(new String("Hello !!" + greeting), HttpStatus.OK);
	}

}
