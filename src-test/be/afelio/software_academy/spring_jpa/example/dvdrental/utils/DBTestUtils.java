package be.afelio.software_academy.spring_jpa.example.dvdrental.utils;

import java.text.*;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBTestUtils {

	private JdbcTemplate jdbcTemplate;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public DBTestUtils(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public void insertCity(String name, int countryId) {
		jdbcTemplate.update("insert into city(city, country_id) values(?, ?)", name, countryId);
	}
	
	public void deleteCity(String name) {
		jdbcTemplate.update("delete from city where city = ?", name);
	}
	
	public void deleteCountry(String name) {
		jdbcTemplate.update("delete from country where country = ?", name);
	}
	
	public int insertRental(int customerId, int inventoryId, int staffId, Date rentalDate) {
		java.sql.Date sqlDate = new java.sql.Date(rentalDate.getTime());
		jdbcTemplate.update("insert into rental(customer_id, inventory_id, staff_id, rental_date) values(?, ?, ?, ?)", 
				customerId, inventoryId, staffId, sqlDate);
		return jdbcTemplate.queryForObject("select rental_id from rental where customer_id = ? and inventory_id = ? and staff_id = ? and rental_date = ?", 
				Integer.class, customerId, inventoryId, staffId, sqlDate);
	}
	
	public Date selectRentalReturnDate(int rentalId) {
		return jdbcTemplate.queryForObject("select return_date from rental where rental_id = ?", Date.class, rentalId);
	}
	
	public void deleteRental(int id) {
		jdbcTemplate.update("delete from rental where rental_id = ?", id);
	}
	
	public void deleteRental(int inventoryId, int customerId, Date rentalDate) {
		java.sql.Date sqlDate = new java.sql.Date(rentalDate.getTime());
		jdbcTemplate.update("delete from rental where inventory_id = ? and customer_id = ? and rental_date = ?", inventoryId, customerId, sqlDate);
	}
	
	public void deleteRental(Date rentalDate) {
		java.sql.Date sqlDate = new java.sql.Date(rentalDate.getTime());
		jdbcTemplate.update("delete from rental where rental_date = ?", sqlDate);
	}
	
	public Date createDate(int year, int month, int day) {
		try {
			return dateFormat.parse(String.format("%s-%02d-%02d 00:00:00", year, month, day));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
