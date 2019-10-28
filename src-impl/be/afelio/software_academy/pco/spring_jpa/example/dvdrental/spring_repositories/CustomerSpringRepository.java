package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSpringRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findOneByEmail(String email);
}
