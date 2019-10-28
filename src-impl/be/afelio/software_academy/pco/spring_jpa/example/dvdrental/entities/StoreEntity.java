package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities;

import javax.persistence.*;

@Entity(name="Store")
@Table(name="store")
public class StoreEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id") 
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private AddressEntity address;
	
	public AddressEntity getAddress() {
		return address;
	}
}
