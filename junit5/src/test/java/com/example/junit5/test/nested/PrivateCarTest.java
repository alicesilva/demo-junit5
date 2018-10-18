package com.example.junit5.test.nested;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class PrivateCarTest {

    private PrivateCar privateCar = null;

    @BeforeEach
    public void init() {
    	privateCar = new PrivateCar("sedan", "BOX1458", true);
    }

    private static String checkNotNull(String model1, String model2) {
		if (model1 == null || model2 == null) {
			return "Model can't be null.";
		} return "ok";
	}

    @Test
	public String getModel() {
		return "sedan";
	}
	
    @Test 
	public String getPlate() {
		return "BOX1458";
	}

    @Test
	public final PrivateCar call() {
		return new PrivateCar("sedan", "BOX1458", false);
	}
	
    @Test
	public Boolean isAvailable() {
		return true;
	}

   // Nested class Book -------------------------------------------
    @Nested
    class PrivateCarTestNested {
    	
		@Test
		@DisplayName("eiouheeehe")
		String getModel() {
			return "sedan";
        }

        @Test
        @DisplayName("rrr")
        String getPlate() {
        	return "BOX1458";
        }

        @Test
        @DisplayName("eeeeeeeeeeeee")
        Boolean isAvailable() {
        	return true;
        }
    }
}