package io.github.FilCx.project.features.restaurant;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.FilCx.project.features.order.Order;
import io.github.FilCx.project.features.product.Product;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY
	private Long restaurant_id;
	private String restaurant_name;
	private String restaurant_address;

	@JsonIgnore
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private Set<Product> products;

	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private Set<Order> orders;

	public Restaurant() {
	}

	public Restaurant(String name, String address) {
		this.restaurant_name = name;
		this.restaurant_address = address;
	}

	@Override
	public String toString() {
		return String.format("Restaurant[id=%d, name='%s', address='%s']", restaurant_id, restaurant_name,
				restaurant_address);
	}

	public Long getId() {
		return restaurant_id;
	}

	public String getName() {
		return restaurant_name;
	}

	public String getAddress() {
		return restaurant_address;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setName(String name) {
		this.restaurant_name = name;
	}

	public void setAddress(String address) {
		this.restaurant_address = address;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
