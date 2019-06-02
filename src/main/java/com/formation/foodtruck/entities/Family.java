package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the Family database table.
 * 
 */
@Entity
@NamedQuery(name="Family.findAll", query="SELECT f FROM Family f")
public class Family implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="family_id")
	private int familyId;

	private String type;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="family")
	private List<Product> products;

	//bi-directional many-to-many association to Meal
	@JsonIgnore
	@ManyToMany
	@JoinColumn(name="family_id")
	private List<Meal> meals;

	public Family() {
	}

	public int getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setFamily(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setFamily(null);

		return product;
	}

	public List<Meal> getMeals() {
		return this.meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

}