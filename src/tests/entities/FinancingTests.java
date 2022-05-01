package tests.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {
	
	@Test
	public void shouldCreateFinancingWhenWithValidParameters() {
		
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedEntry = totalAmount / 5;
		Financing fin = new Financing(totalAmount , income, 80);
		
		Assertions.assertEquals(1000.0, fin.quota());
		Assertions.assertEquals(expectedEntry, fin.entry());
		
	}
	
	
	@Test
	public void shouldThrowExceptionWhenFinancingWithInvalidValue() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = new Financing(100000.0, 2000.0, 20);
	
		});
		
	}
	
}
