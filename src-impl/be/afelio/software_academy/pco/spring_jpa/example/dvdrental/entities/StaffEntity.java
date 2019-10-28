package be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities;

import javax.persistence.*;

@Entity(name="Staff")
@Table(name="staff")
@NamedQueries({
	@NamedQuery(name="findOneStaffByUsername", query="select s from Staff s where s.username = ?1")
})
public class StaffEntity {

	@Id
	@Column(name="staff_id") 
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "store_id")
	private StoreEntity store;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public StoreEntity getStore() {
		return store;
	}

	public void setStore(StoreEntity store) {
		this.store = store;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@SuppressWarnings("unused")
	private String username;
}
