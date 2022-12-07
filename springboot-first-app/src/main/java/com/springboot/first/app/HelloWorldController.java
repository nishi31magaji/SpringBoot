package com.springboot.first.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // this converts java object to json or xml and return.
//@RestController = @Controller + @ResponseBody


@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@GetMapping("/hello-world-new")
	public String helloWorldNew() {
		return "Hello World New!!";
	}
}
