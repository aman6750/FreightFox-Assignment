package com.masai.junit_example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest 
{
   
	@BeforeAll
	static void init() {
		System.out.println("Inside before all");
	}
	
	@BeforeEach
	void show() {
		System.out.println("Inside before each");
		
	}
	
	@Test
	void test() {
		System.out.println("Inside test");
	}
	
	@AfterEach
	void foo() {
		System.out.println("Inside after each");
	}
	
	@AfterAll
	static void destroy() {
		System.out.println("Inside after all");
	}
	
}
