package com.example.junit5.test.assertions;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

@RunWith(JUnitPlatform.class)
class StringUtilsTest {
	
	@Test
	protected void testConcatString() {
		String a = "alice";
		String b = "glauber";
		
		assertAll("concat", () -> assertEquals("aliceglauber", StringUtils.concat(a, b)),
				() -> assertNotEquals("", StringUtils.concat(a, b)),
				() -> assertNotNull(StringUtils.concat(a,b)));
	}
	
	@Disabled
    @Test
    void testConvertToDoubleWithNullArgument() {

        String age = null;
        Double actual = StringUtils.convertToDouble(age);

        assertNull(actual, "The actual is not null");

        assertNull(actual, () -> "The actual is not null");
    }

    @Test
    public void testConvertToDoubleThrowException() {
 
        String age = null;
        
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.convertToDouble(age);
        });

        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });
    }

    @Test
    public void testIsNullOrBlank() {
 
        String input = null;

        assertTrue(StringUtils.isNullOrBlank(input));

        assertTrue(StringUtils.isNullOrBlank(input), () -> "The string is not null or blank");

        input = " ";
        assertTrue(StringUtils.isNullOrBlank(input));
        
        input = "abc";
        assertFalse(StringUtils.isNullOrBlank(input));

    }

    @Test
    public void testGetDefaultIfNull() {
   
        String str = null;
        String defaultStr = "abc";

        String actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertSame(defaultStr, actual);
        assertSame(defaultStr, actual, () -> "Expected ouput is same with actual");

        str = "def";
        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertNotSame(defaultStr, actual);
        assertNotSame(defaultStr, actual, () -> "Expected ouput is not same with actual");
    }

    @Test
    public void testConcatWithRegularInput() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "!";
        String expect = str1 + str2 + str3;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expect, actual);
    }

    @Test
    public void testConcatWithNullInput() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = null;
        String expect = str1 + str2;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expect, actual);
    }
}