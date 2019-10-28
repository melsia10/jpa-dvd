package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities;

import javax.persistence.*;

import be.afelio.software_academy.spring_jpa.example.dvdrental.beans.Country;

@Entity(name="Country")
@Table(name="country")
@NamedQueries({
	@NamedQuery(name="findOneCountryByName", query="select c from Country c where c.name = ?1")
})
public class CountryEntity extends Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id") 
	private Integer id;
	
	@Column(name="country")
	private String name;
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
