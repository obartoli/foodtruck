package com.formation.foodtruck.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Orders o")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;

	@Column(name="date_command")
	private LocalDate dateCommand;

	@Column(name="date_delivery")
	private LocalDate dateDelivery;

	@Column(name="total_price")
	private float totalPrice;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;

	//bi-directional many-to-one association to LineOrder
	@OneToMany(mappedBy="order")
	private List<LineOrder> lineOrders;

	public Orders() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDateCommand() {
		return this.dateCommand;
	}

	public void setDateCommand(LocalDate dateCommand) {
		this.dateCommand = dateCommand;
	}

	public LocalDate getDateDelivery() {
		return this.dateDelivery;
	}

	public void setDateDelivery(LocalDate dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<LineOrder> getLineOrders() {
		return this.lineOrders;
	}

	public void setLineOrders(List<LineOrder> lineOrders) {
		this.lineOrders = lineOrders;
	}

	public LineOrder addLineOrder(LineOrder lineOrder) {
		getLineOrders().add(lineOrder);
		lineOrder.setOrder(this);

		return lineOrder;
	}

	public LineOrder removeLineOrder(LineOrder lineOrder) {
		getLineOrders().remove(lineOrder);
		lineOrder.setOrder(null);

		return lineOrder;
	}

}