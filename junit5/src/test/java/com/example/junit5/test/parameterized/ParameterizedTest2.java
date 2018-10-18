package com.example.junit5.test.parameterized;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


public class ParameterizedTest2 {

	@ParameterizedTest(name =  "Parameterized test {index}: {0}")
	@ValueSource(strings = { "Hello", "World" })
	public void parameterizedTest1(String argument) {
		assertNotNull(argument);
	}

	static Collection<String> parameterFactory() {
		return Arrays.asList("Hello", "World");
	}

	@ParameterizedTest
	@MethodSource("parameterFactory")
	public void parameterizedTest2(String argument) {
		assertNotNull(argument);
	}

	static Collection<Arguments> parameterFactory1() {
		return Arrays.asList(Arguments.of("Hello", 1), Arguments.of("World", 1));
	}

	@ParameterizedTest
	@MethodSource("parameterFactory1")
	public void parameterizedTest3(String argument, int count) {
		assertNotNull(argument);
		assertTrue(count > 0);
	}

	@ParameterizedTest
	@CsvSource({ "Hello, 1", "World, 2"})
	public void parameterizedTest4(String argument, int count) {
		assertNotNull(argument);
		assertTrue(count > 0);
	}
}
