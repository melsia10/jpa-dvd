package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.CityEntity;

public interface CitySpringRepository extends JpaRepository<CityEntity, Integer> {
	
	// select c from City c where c.country.name = ?1
	List<CityEntity> findAllByCountryName(String name);
	
	// select c from City c where c.name = ?1 and c.country.name = ?2
	CityEntity findOneByNameAndCountryName(String name, String countryName);
}
