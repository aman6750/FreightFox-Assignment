package com.masai.junit_example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstanceStaticBehaviourInTest {
	
	static int i=100; // class variable
	int j=10; // instance variable
	
	@BeforeEach
	void abc() {
		i++;
		j--;
	}

	@Test
	void test() {
		System.out.println("Test :"+i+" "+j);
	}
	
	@Test
	void anotherTest() {
		System.out.println("Another Test :"+i+" "+j);
	}
	
	@AfterEach
	void pqr() {
		i++;
		j--;
	}
	
	

}
