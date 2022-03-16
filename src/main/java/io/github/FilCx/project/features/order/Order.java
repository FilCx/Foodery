package io.github.FilCx.project.features.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.github.FilCx.project.features.restaurant.Restaurant;
import io.github.FilCx.project.features.user.User;

@Entity
@Table(name = "`order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;

	@ManyToOne
	@JoinColumn(name = "user_user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_restaurant_id")
	private Restaurant restaurant;
	
	protected Order() {
	}

	public Order(User user, Restaurant restaurant) {
		this.user = user;
		this.restaurant 	= restaurant;
	}

	public Long getId() {
		return order_id;
	}

	public void setId(Long id) {
		this.order_id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Order [" + "user=" + user + ", restaurant=" + restaurant + "]";
	}
}
