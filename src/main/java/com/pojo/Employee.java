package com.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private int age;
	private int rollno;
	private String firstName;
	private String lastName;
	private List<String> course;

}
