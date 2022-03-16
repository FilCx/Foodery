package io.github.FilCx.project.features.product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.FilCx.project.features.restaurant.Restaurant;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	private String product_name;
	private int product_price;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_restaurant_id")
	private Restaurant restaurant;

	protected Product() {
	}

	public Product(String name, int price, Restaurant restaurant) {
		this.product_name = name;
		this.product_price = price;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, name='%s', price='%s']", product_id, product_name, product_price);
	}

	public Long getId() {
		return product_id;
	}

	public String getName() {
		return product_name;
	}

	public int getPrice() {
		return product_price;
	}

	public void setName(String name) {
		this.product_name = name;

	}

	public void setPrice(int price) {
		this.product_price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
