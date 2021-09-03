package dev.danvega.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

// DTO koji preuzima podatke iz HTML forme za registraciju
public class UserRequest {

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	private String adress;

	private String city;

	private String country;

	private String phone;

	private String role;

	private Long apotecary_id;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime startHours;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime endHours;

	public UserRequest() {
	}

	public UserRequest(String username, String firstname, String lastname, String email, String adress, String city, String country, String phone, String role) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.role = role;
	}

	public UserRequest(String username, String firstname, String lastname, String email, String adress, String city, String country, String phone, String role, Long apotecary_id) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.role = role;
		this.apotecary_id = apotecary_id;
	}

	public UserRequest(String username, String firstname, String lastname, String email, String adress, String city, String country, String phone, String role, Long apotecary_id, LocalTime startHours, LocalTime endHours) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.role = role;
		this.apotecary_id = apotecary_id;
		this.startHours = startHours;
		this.endHours = endHours;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getApotecary_id() {
		return apotecary_id;
	}

	public void setApotecary_id(Long apotecary_id) {
		this.apotecary_id = apotecary_id;
	}

	public LocalTime getStartHours() {
		return startHours;
	}

	public void setStartHours(LocalTime startHours) {
		this.startHours = startHours;
	}

	public LocalTime getEndHours() {
		return endHours;
	}

	public void setEndHours(LocalTime endHours) {
		this.endHours = endHours;
	}
}
