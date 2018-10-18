package com.example.junit5.test.beforeafter;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.example.junit5.test.assertions.PrivateCar;


@RunWith(JUnitPlatform.class)
public class BeforeAfterTest {
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Running before each test.");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Running before all test.");
	}
	
	@Test
    @RepeatedTest(5)
	public void newUberTest() {
		PrivateCar privateCar = PrivateCar.of("Civic", "MLU-3333");
		assertAll("Private Car tests", 
				() -> assertEquals("Civic", privateCar.getModel()),
				() -> assertEquals("MLU-3333", privateCar.getPlate()));
	}
	
	@Test
	@RepeatedTest(5)
	public void newUberTest2() {
		PrivateCar privateCar2 = PrivateCar.of("Ford", "MGT-8888");
		assertAll("Private Car tests", 
				() -> assertEquals("Ford", privateCar2.getModel()),
				() -> assertEquals("MGT-8888", privateCar2.getPlate()));
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Running after each test.");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Running after all tests.");
	}
}
