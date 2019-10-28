package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffSpringRepository extends JpaRepository<StaffEntity, Integer> {
    StaffEntity findOneByUsername(String username);
}
