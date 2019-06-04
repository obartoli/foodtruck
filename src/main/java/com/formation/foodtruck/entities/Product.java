package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the Product database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p"),
	@NamedQuery(name="Product.findByMeal", query="SELECT p FROM Product p"), //TODO trier sur les repas
	@NamedQuery(name="Product.findByFamily", query="SELECT p FROM Product p WHERE p.family.familyId = :familyId")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;

	private String availability;

	private String description;

	private String name;

	private float price;

	private int stock;

	//bi-directional many-to-one association to LineOrder
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<LineOrder> lineOrders;

	//bi-directional many-to-one association to Family
	@ManyToOne
	@JoinColumn(name="family_id")
	private Family family;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<LineOrder> getLineOrders() {
		return this.lineOrders;
	}

	public void setLineOrders(List<LineOrder> lineOrders) {
		this.lineOrders = lineOrders;
	}

	public LineOrder addLineOrder(LineOrder lineOrder) {
		getLineOrders().add(lineOrder);
		lineOrder.setProduct(this);

		return lineOrder;
	}

	public LineOrder removeLineOrder(LineOrder lineOrder) {
		getLineOrders().remove(lineOrder);
		lineOrder.setProduct(null);

		return lineOrder;
	}

	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

}