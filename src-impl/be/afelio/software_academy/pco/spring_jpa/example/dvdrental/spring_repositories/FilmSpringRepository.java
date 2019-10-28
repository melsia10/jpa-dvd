package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories;

import be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmSpringRepository extends JpaRepository<FilmEntity, Integer> {
    FilmEntity findOneByTitle(String title);
}
