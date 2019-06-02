package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Type_address database table.
 * 
 */
@Entity
@Table(name="Type_address")
@NamedQuery(name="TypeAddress.findAll", query="SELECT t FROM TypeAddress t")
public class TypeAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_address_id")
	private int typeAddressId;

	private String type;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="typeAddress")
	private List<Address> addresses;

	public TypeAddress() {
	}

	public int getTypeAddressId() {
		return this.typeAddressId;
	}

	public void setTypeAddressId(int typeAddressId) {
		this.typeAddressId = typeAddressId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setTypeAddress(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setTypeAddress(null);

		return address;
	}

}