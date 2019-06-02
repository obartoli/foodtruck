package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Line_order database table.
 * 
 */
@Entity
@Table(name="Line_order")
@NamedQuery(name="LineOrder.findAll", query="SELECT l FROM LineOrder l")
public class LineOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="line_order_id")
	private int lineOrderId;

	@Column(name="effective_price")
	private float effectivePrice;

	private int quantity;

	private float rate;

	@Column(name="total_price")
	private float totalPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public LineOrder() {
	}

	public int getLineOrderId() {
		return this.lineOrderId;
	}

	public void setLineOrderId(int lineOrderId) {
		this.lineOrderId = lineOrderId;
	}

	public float getEffectivePrice() {
		return this.effectivePrice;
	}

	public void setEffectivePrice(float effectivePrice) {
		this.effectivePrice = effectivePrice;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return this.rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Orders getOrder() {
		return this.order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}