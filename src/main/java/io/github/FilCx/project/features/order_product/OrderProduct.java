package io.github.FilCx.project.features.order_product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.github.FilCx.project.features.order.Order;
import io.github.FilCx.project.features.product.Product;

@Entity
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_product_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_order_id")
	private Order order;
	
	@Column(name = "order_product_quantity")
	private int quantity;
	
	public OrderProduct() {
	}

	public OrderProduct(Order order, Product product, int quantity) {
		super();
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
