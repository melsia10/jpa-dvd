package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.AddressEntity;

public interface AddressSpringRepository extends JpaRepository<AddressEntity, Integer> {

	// select a from Address a where a.city.country.name = ?1
	List<AddressEntity> getAllByCityCountryName(String name);
	AddressEntity findOneByAddress(String address);
}
