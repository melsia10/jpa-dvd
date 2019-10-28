package be.afelio.software_academy.spring_jpa.example.dvdrental;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.afelio.software_academy.spring_jpa.example.dvdrental.config.ApplicationConfig;
import be.afelio.software_academy.spring_jpa.example.dvdrental.utils.DBTestUtils;

public class Factory {
	
	private static ApplicationContext ctx 
		= new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
	public static DvdRentalExampleSpringJpaRepository createDvdRentalExerciseRepository() {
		DvdRentalExampleSpringJpaRepository repository
			= ctx.getBean(DvdRentalExampleSpringJpaRepository.class);
		return repository;
	}
	
    public static DBTestUtils createDBTestUtils() {
    	DBTestUtils dbTestUtils = ctx.getBean(DBTestUtils.class);
    	return dbTestUtils;
    }
}
