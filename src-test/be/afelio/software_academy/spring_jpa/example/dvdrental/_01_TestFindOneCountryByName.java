package be.afelio.software_academy.spring_jpa.example.dvdrental;


import be.afelio.software_academy.spring_jpa.example.dvdrental.DvdRentalExampleSpringJpaRepository;
import be.afelio.software_academy.spring_jpa.example.dvdrental.beans.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class _01_TestFindOneCountryByName {

	private DvdRentalExampleSpringJpaRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
		repository = Factory.createDvdRentalExerciseRepository();
		assertNotNull(repository);
	}

	@Test
	void testExistingCountry() {
		Country expected = new Country() {
			public String getName() {
				return "France";
			}
		};
		
		Country actual = repository.findOneCountryByName(expected.getName());
		
		assertEquals(expected, actual);
	}

	@Test
	void testNonExistingCountry() {
		String name = "Belgium";
		
		Country country = repository.findOneCountryByName(name);
		
		assertNull(country);
	}
	
	@Test
	void testNullCountry() {
		String name = null;
		
		Country country = repository.findOneCountryByName(name);
		
		assertNull(country);
	}
}
