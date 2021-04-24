package com.example.cash.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
	
	static void maxYear(String depts, Long max, int current, String dept) {
		if(current == depts.length()) {
			System.out.println("제일 많은 학년 :" + dept + "학년 :" + max +"명");
		}
		Long value = Arrays.stream(depts.replaceAll("[^"+ depts.charAt(current) +"]", "").split("")).collect(Collectors.counting());
		if(max < value) {
			max = value;
			dept = Character.toString(depts.charAt(current));
		}
		maxYear(depts, max, current+1, dept);
	}
	
	public static void main(String[] args) {
		Student[] student = new Student[4]; 
		student[0] = new Student("a",1,"1");
		student[1] = new Student("b",2,"2");
		student[2] = new Student("b",3,"3");
		student[3] = new Student("b",4,"1");
		
		maxYear(Arrays.stream(student).map(data->data.getDept()).collect(Collectors.joining()), 0L, 0, "0");
	}
}

class Student{
	private String name;
	private int year;
	private String dept;
	
	Student(String name, int year, String dept) {
		this.name = name;
		this.year = year;
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}
}