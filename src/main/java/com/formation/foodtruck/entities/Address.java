package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;

	private String city;

	private String country;

	private int nbStreet;

	private String street;

	private int zipCode;

	//bi-directional many-to-one association to TypeAddress
	@ManyToOne
	@JoinColumn(name="type_address_id")
	private TypeAddress typeAddress;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="address")
	private List<Company> companies;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<Users> users;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="address")
	private List<Orders> orders;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getNbStreet() {
		return this.nbStreet;
	}

	public void setNbStreet(int nbStreet) {
		this.nbStreet = nbStreet;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public TypeAddress getTypeAddress() {
		return this.typeAddress;
	}

	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setAddress(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setAddress(null);

		return company;
	}

	public List<Users> getUsers() {
		return this.users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users addUser(Users user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public Users removeUser(Users user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

	public List<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Orders addOrder(Orders order) {
		getOrders().add(order);
		order.setAddress(this);

		return order;
	}

	public Orders removeOrder(Orders order) {
		getOrders().remove(order);
		order.setAddress(null);

		return order;
	}

}