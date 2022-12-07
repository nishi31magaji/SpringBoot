package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data /// as this is not working we have added constructor and setter methods.
//GeneratedValue & GenerationType is not supported so need to add id manually.
@Entity
@Table(name = "employees") // if we dont provide name it will take name of the class as name
public class Employee {

	@Id
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public Employee(long id, String firstName, String lastName, String email) {
	 * super(); this.id = id; this.firstName = firstName; this.lastName = lastName;
	 * this.email = email; }
	 * 
	 * public Employee() {
	 * 
	 * }
	 */

}
