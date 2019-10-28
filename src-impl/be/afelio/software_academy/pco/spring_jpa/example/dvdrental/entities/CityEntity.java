package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities;

import javax.persistence.*;

import be.afelio.software_academy.spring_jpa.example.dvdrental.beans.City;

@Entity(name="City")
@Table(name="city")
public class CityEntity extends City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id")
	private Integer id;
	
	@Column(name="city")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private CountryEntity country;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public CountryEntity getCountry() {
		return country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
}
