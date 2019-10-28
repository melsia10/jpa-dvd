package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreSpringRepository extends JpaRepository<StoreEntity, Integer> {
    StoreEntity findOneByAddress(String address);
}
