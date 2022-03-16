package io.github.FilCx.project.features.product;

import io.github.FilCx.project.features.restaurant.RestaurantDto;

public class ProductDto {
	
	private Long id;
	private String name;
	private int price;
	private RestaurantDto restaurant;
	
	public ProductDto() {
		
	}
	
	public ProductDto(String name, int price, RestaurantDto restaurant) {
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public RestaurantDto getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}
}