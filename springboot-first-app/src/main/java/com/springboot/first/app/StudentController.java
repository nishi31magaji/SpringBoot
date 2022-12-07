package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
 @GetMapping("/student")
 public Student getStudent() {
	 return new Student("nishi","magnish");
 }
 
 @GetMapping("/students")
 public List<Student> getStudents(){
	 List<Student> students = new ArrayList<>();
	 students.add(new Student("nishi","magnish"));
	 students.add(new Student("john","mathew"));
	 students.add(new Student("krish","dan"));
	 return students;
 }
 
 //pathvariable
 ////http://localhost:8080/student/nishi/magnish
 // we can have any uri here can be http://localhost:8080/nishi/magnish
 @GetMapping("/student/{firstName1}/{lastName1}")
 public Student getStudentPathVariable(@PathVariable("firstName1")String firstName,@PathVariable("lastName1")String lastName) {
	 //bind values of firstName and lastName
	 return new Student(firstName,lastName);
 }
  //build rest api to handle query parameters
 //http://localhost:8080/student?firstName=Nishi
 // to bind web parameter/query parameter to method argument
 @GetMapping("/student/query")
 public Student studentQueryParam(
		 @RequestParam(name="firstName") String firstName,
		 @RequestParam(name="lastName") String lastName) {
	 return new Student(firstName,lastName);
 }
}
