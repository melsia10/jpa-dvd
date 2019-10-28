package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.RentalEntity;

public interface RentalSpringRepository extends JpaRepository<RentalEntity, Integer>{

	// select r from Rental r where r.inventory.film.title = ?1 order by r.rentalDate
	List<RentalEntity> findAllByInventoryFilmTitleOrderByRentalDate(String title);
}
