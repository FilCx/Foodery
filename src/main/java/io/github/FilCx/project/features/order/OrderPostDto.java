package io.github.FilCx.project.features.order;

import io.github.FilCx.project.features.restaurant.RestaurantDto;
import io.github.FilCx.project.features.user.UserDto;

public class OrderPostDto {

	private Long id;
	private UserDto user;
	private RestaurantDto restaurant;
	
	public OrderPostDto() {
		
	}
	
	public OrderPostDto(UserDto user, RestaurantDto restaurant) {
		this.user = user;
		this.restaurant = restaurant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public RestaurantDto getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDto restaurant) {
		this.restaurant = restaurant;
	}
}
